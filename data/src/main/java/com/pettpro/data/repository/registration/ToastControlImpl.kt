package com.pettpro.data.repository.registration

import android.content.Context
import android.widget.Toast
import com.pettpro.domain.registration.ToastControl
import javax.inject.Inject


class ToastControlImpl (private val context: Context) :ToastControl {
    private var mToast: Toast? = null
   override fun show( text: String?) {
        if (mToast != null) mToast!!.cancel()
        mToast = Toast.makeText(context, text,Toast.LENGTH_SHORT)
        mToast!!.show()
    }
}