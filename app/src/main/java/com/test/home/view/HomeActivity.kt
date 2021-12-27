package com.test.home.view
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.R
import com.test.base.activity.BaseDataBindingActivity
import com.test.databinding.HomeDataBinding
import com.test.di.DaggerProvider
import com.test.di.modules.ViewModules.ViewModelFactory
import com.test.home.adapter.MostViewedAdapter
import com.test.home.callbacks.HomeViewCallbacks
import com.test.home.model.ResultsItem
import com.test.home.viewmodel.HomeVM
import com.test.network.Status
import com.test.util.CommonUtilities
import com.test.util.Constants
import javax.inject.Inject


class HomeActivity : BaseDataBindingActivity<HomeDataBinding>(R.layout.activity_home),
    HomeViewCallbacks {


    @Inject
    lateinit var viewModFactory: ViewModelFactory
    lateinit var vm: HomeVM

    var mostViewedList : ArrayList<ResultsItem> = ArrayList()


    override fun onDataBindingCreated() {
        binding.callback = this
        binding.lifecycleOwner = this

        initListeners()

    }

    private fun initListeners() {

        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.swipeRefreshLayout.isRefreshing =false
            hitApi()
        }

    }

    override fun injectDaggerComponent() {
        DaggerProvider.getAppComponent()?.inject(this)
        vm = ViewModelProvider(this, viewModFactory).get(HomeVM::class.java)

        hitApi()
        CommonUtilities.showLoader(this)


    }

    private fun hitApi() {
        if(CommonUtilities.isConnectingToInternet(this) == true) {

            vm.getMostPopular(Constants.API_KEY)
            setupObserver()
        }else
        {
            CommonUtilities.showToast(this,"No Internet Connection...")
        }
    }


    private fun setupObserver() {


        vm.responseGetData.observe(this, {
            when (it.status) {
                Status.SUCCESS -> {

                    CommonUtilities.hideLoader()
                    Log.e("TAG", "SUCCESS")


                    if (it.data?.results!=null)
                    {

                        mostViewedList.clear()
                        mostViewedList.addAll(it.data.results)


                        if (mostViewedList.isNotEmpty())
                        {
                            initRecyclerView(mostViewedList)

                        }


                    }


                }
                Status.LOADING -> {

                    Log.e("TAG", "LOADING")

                }
                Status.ERROR -> {

                    CommonUtilities.hideLoader()
                    Log.e("TAG", "ERROR ")
                }
            }
        })


    }

    private fun initRecyclerView(mostViewedList: ArrayList<ResultsItem>) {

        val myAdapter =
            MostViewedAdapter(this, mostViewedList)
        binding.rvList.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter = myAdapter
        }


    }





}