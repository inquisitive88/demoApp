package com.test.util

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.tapadoo.alerter.Alerter
import java.text.SimpleDateFormat
import java.util.*
import cn.pedant.SweetAlert.SweetAlertDialog
import com.blogspot.atifsoftwares.animatoolib.Animatoo
import com.test.R


class CommonUtilities {

    companion object {
        lateinit var dialog3: Dialog

        @JvmStatic
        fun putInt(
            activity: Context,
            name: String?,
            value: Int
        ) {
            val preferences = activity.getSharedPreferences(
                Constants.TEST_APP, Context.MODE_PRIVATE
            )
            preferences.edit().putInt(name, value).apply()
        }

        fun getInt(activity: Context, name: String?): Int {
            val preferences = activity.getSharedPreferences(
                Constants.TEST_APP,
                Context.MODE_PRIVATE
            )
            return preferences.getInt(name, 0)
        }

        fun putFloat(
                activity: Context,
                name: String?,
                value: Float
        ) {
            val preferences = activity.getSharedPreferences(
                    Constants.TEST_APP, Context.MODE_PRIVATE
            )
            preferences.edit().putFloat(name, value).apply()
        }

        fun getFloat(activity: Context, name: String?): Float {
            val preferences = activity.getSharedPreferences(
                    Constants.TEST_APP,
                    Context.MODE_PRIVATE
            )
            return preferences.getFloat(name, 0f)
        }

        fun fireActivityIntent(
            sourceActivity: Activity,
            mIntent: Intent,
            isFinish: Boolean,
            isForward: Boolean
        ) {
            sourceActivity.startActivity(mIntent)
            if (isFinish) {
                sourceActivity.finish()
            }
            if (isForward) {
                sourceActivity.overridePendingTransition(
                    R.anim.slide_in_left,
                    R.anim.slide_out_left
                )
            } else {
                sourceActivity.overridePendingTransition(
                    R.anim.slide_in_right,
                    R.anim.slide_out_right
                )
            }
        }




        fun changeStatusBarColor(activity: Activity, color: Int) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = activity.window
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.statusBarColor = color
            }
        }

        fun getCurrentDateTime(): String? {
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
            return sdf.format(Date())

        }


        fun putString(
            activity: Context,
            name: String?,
            value: String?) {
            val preferences = activity.getSharedPreferences(
                Constants.TEST_APP,
                Context.MODE_PRIVATE
            )
            preferences.edit().putString(name, value).apply()
        }

        fun getString(activity: Context, name: String?): String? {
            val preferences = activity.getSharedPreferences(
                Constants.TEST_APP,
                Context.MODE_PRIVATE
            )
            return preferences.getString(name, "")
        }


        fun putBoolean(
            activity: Context,
            name: String?,
            value: Boolean
        ) {
            val preferences = activity.getSharedPreferences(
                Constants.TEST_APP,
                Context.MODE_PRIVATE
            )
            preferences.edit().putBoolean(name, value).apply()
        }

        fun getBoolean(activity: Context, name: String?): Boolean {
            val preferences = activity.getSharedPreferences(
                Constants.TEST_APP,
                Context.MODE_PRIVATE
            )
            return preferences.getBoolean(name, false)
        }

        fun clearPrefrences(activity: Context) {
            val preferences = activity.getSharedPreferences(
                Constants.TEST_APP,
                Context.MODE_PRIVATE
            )
            preferences.edit().clear().apply()


        }

        fun showToast(context: Context?, msg: String?) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }

        fun showLoader(context: Context) {
            dialog3 = Dialogs.getLoadingDialog(context)
            dialog3.show()
        }

        fun hideLoader() {

            try {
                if (dialog3.isShowing) {
                    dialog3.cancel()
                    dialog3.dismiss()
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        fun animRight(activity: Activity?): Animation? {
            return AnimationUtils.loadAnimation(activity, R.anim.enter_from_rightslow)
        }

        fun animShake(activity: Activity?): Animation? {
            return AnimationUtils.loadAnimation(activity, R.anim.shake_animation)
        }

        fun animTopToCenter(activity: Activity?): Animation? {
            return AnimationUtils.loadAnimation(activity, R.anim.grow_from_top)
        }

        fun fadeIn(activity: Activity?): Animation? {
            return AnimationUtils.loadAnimation(activity, R.anim.fade_in_anim)
        }


        fun getFilePath(
            selectedImage: Uri?,
            context: Context
        ): String? {
            val filePathColumn =
                arrayOf(MediaStore.Images.Media.DATA)
            val cursor =
                context.contentResolver.query(selectedImage!!, filePathColumn, null, null, null)
            cursor!!.moveToFirst()
            val columnIndex = cursor.getColumnIndex(filePathColumn[0])
            val filePath = cursor.getString(columnIndex)
            cursor.close()
            println("File path $filePath")
            return filePath
        }

        fun isConnectingToInternet(context: Context): Boolean? {
            val connectivity =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = connectivity.allNetworkInfo
            if (info != null) {
                for (i in info) {
                    if (i.state == NetworkInfo.State.CONNECTED) {
                        return true
                    }
                }
            }
            return false
        }


        fun showAlerterError(context: Context?, message: String?) {
            message?.let {
                Snackbar.make(
                    (context as Activity?)?.findViewById(android.R.id.content)!!,
                    it,
                    Snackbar.LENGTH_SHORT
                )
                    .show()
            }
        }

        fun showError(context: Context?, message: String?) {
            Alerter.create((context as Activity?)!!)
                .setTitle("Alert")
                .setText(message)
                .setBackgroundColorRes(R.color.colorPrimaryDark)
                .setTextTypeface(Typeface.DEFAULT_BOLD)
                .show().setVibrationEnabled(true)
        }


    }


}