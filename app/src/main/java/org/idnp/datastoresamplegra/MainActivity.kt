package org.idnp.datastoresamplegra

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.res.ResourcesCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.prefs.Preferences


class MainActivity : AppCompatActivity() {
    //private val Context.dataStore by preferencesDataStore(NotePrefs.PREFS_NAME)
    //lateinit var notePrefs: NotePrefs

    private val Context.dataStore by preferencesDataStore(name = "settings")

    companion object{
        val USER_BACKGROUND_KEY = intPreferencesKey("USER_BACKGROUND")
        val USER_FONT_KEY = stringPreferencesKey("USER_FONT")
        val USER_SIZE_KEY = floatPreferencesKey("USER_SIZE")
    }

    suspend fun storeColor( color: Int){
        dataStore.edit {
            it[USER_BACKGROUND_KEY] = color
        }
    }

    suspend fun storeFont( font: String){
        dataStore.edit {
            it[USER_FONT_KEY] = font
        }
    }

    suspend fun storeSize( size: Float){
        dataStore.edit {
            it[USER_SIZE_KEY] = size
        }
    }

    lateinit var layoutConst: LinearLayout

    lateinit var floatingcolor1: FloatingActionButton
    lateinit var floatingcolor2: FloatingActionButton
    lateinit var floatingcolor3: FloatingActionButton
    lateinit var floatingcolor4: FloatingActionButton

    lateinit var input1: TextInputLayout
    lateinit var input2: TextInputLayout
    lateinit var input3: TextInputLayout
    lateinit var input4: TextInputLayout
    lateinit var input5: TextInputLayout
    lateinit var input6: TextInputLayout

    lateinit var text1: TextInputEditText
    lateinit var text2: TextInputEditText
    lateinit var text3: TextInputEditText
    lateinit var text4: TextInputEditText
    lateinit var text5: TextInputEditText
    lateinit var text6: TextInputEditText

    lateinit var btnfont1: Button
    lateinit var btnfont2: Button
    lateinit var btnfont3: Button

    lateinit var btntam1: Button
    lateinit var btntam2: Button
    lateinit var btntam3: Button


    private var fontSizeLow = 12f
    private var fontSizeMedium = 18f
    private var fontSizeHigh = 23f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        layoutConst = findViewById(R.id.mainvertical)

        input1 = findViewById(R.id.textinput_1)
        input2 = findViewById(R.id.textinput_2)
        input3 = findViewById(R.id.textinput_3)
        input4 = findViewById(R.id.textinput_4)
        input5 = findViewById(R.id.textinput_5)
        input6 = findViewById(R.id.textinput_6)

        text1 = findViewById(R.id.text1)
        text2 = findViewById(R.id.text2)
        text3 = findViewById(R.id.text3)
        text4 = findViewById(R.id.text4)
        text5 = findViewById(R.id.text5)
        text6 = findViewById(R.id.text6)

        floatingcolor1 = findViewById(R.id.color1)
        floatingcolor2 = findViewById(R.id.color2)
        floatingcolor3 = findViewById(R.id.color3)
        floatingcolor4 = findViewById(R.id.color4)

        btnfont1 = findViewById(R.id.btnfuente1)
        btnfont2 = findViewById(R.id.btnfuente2)
        btnfont3= findViewById(R.id.btnfuente3)

        btntam1 = findViewById(R.id.btnpeque)
        btntam2 = findViewById(R.id.btnmedio)
        btntam3 = findViewById(R.id.btnalto)

        buttonSave()
    }

    private fun buttonSave() {
        floatingcolor1.setOnClickListener {
            layoutConst.setBackgroundColor(Color.RED)
            lifecycleScope.launch {
                storeColor(Color.RED)
            }
        }

        floatingcolor2.setOnClickListener {
            layoutConst.setBackgroundColor(Color.MAGENTA)
            lifecycleScope.launch {
                storeColor(Color.MAGENTA)
            }
        }

        floatingcolor3.setOnClickListener {
            layoutConst.setBackgroundColor(Color.BLUE)
            lifecycleScope.launch {
                storeColor(Color.BLUE)
            }
        }

        floatingcolor4.setOnClickListener {
            layoutConst.setBackgroundColor(Color.GREEN)
            lifecycleScope.launch {
                storeColor(Color.GREEN)
            }
        }

        btnfont1.setOnClickListener {
            input1.typeface = ResourcesCompat.getFont(this, R.font.garamond)
            input2.typeface = ResourcesCompat.getFont(this, R.font.garamond)
            input3.typeface = ResourcesCompat.getFont(this, R.font.garamond)
            input4.typeface = ResourcesCompat.getFont(this, R.font.garamond)
            input5.typeface = ResourcesCompat.getFont(this, R.font.garamond)
            input6.typeface = ResourcesCompat.getFont(this, R.font.garamond)
            lifecycleScope.launch {
                storeFont(R.font.garamond.toString())
            }
        }

        btnfont2.setOnClickListener {
            input1.typeface = ResourcesCompat.getFont(this, R.font.grapenuts)
            input2.typeface = ResourcesCompat.getFont(this, R.font.grapenuts)
            input3.typeface = ResourcesCompat.getFont(this, R.font.grapenuts)
            input4.typeface = ResourcesCompat.getFont(this, R.font.grapenuts)
            input5.typeface = ResourcesCompat.getFont(this, R.font.grapenuts)
            input6.typeface = ResourcesCompat.getFont(this, R.font.grapenuts)
            lifecycleScope.launch {
                storeFont(R.font.grapenuts.toString())
            }
        }

        btnfont3.setOnClickListener {
            input1.typeface = ResourcesCompat.getFont(this, R.font.macondo)
            input2.typeface = ResourcesCompat.getFont(this, R.font.macondo)
            input3.typeface = ResourcesCompat.getFont(this, R.font.macondo)
            input4.typeface = ResourcesCompat.getFont(this, R.font.macondo)
            input5.typeface = ResourcesCompat.getFont(this, R.font.macondo)
            input6.typeface = ResourcesCompat.getFont(this, R.font.macondo)
            lifecycleScope.launch {
                storeFont(R.font.macondo.toString())
            }
        }

        btntam1.setOnClickListener {
            text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeLow)
            text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeLow)
            text3.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeLow)
            text4.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeLow)
            text5.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeLow)
            text6.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeLow)
            lifecycleScope.launch {
                storeSize(fontSizeLow)
            }
        }

        btntam2.setOnClickListener {
            text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeMedium)
            text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeMedium)
            text3.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeMedium)
            text4.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeMedium)
            text5.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeMedium)
            text6.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeMedium)
            lifecycleScope.launch {
                storeSize(fontSizeMedium)
            }
        }

        btntam3.setOnClickListener {
            text1.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeHigh)
            text2.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeHigh)
            text3.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeHigh)
            text4.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeHigh)
            text5.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeHigh)
            text6.setTextSize(TypedValue.COMPLEX_UNIT_SP,fontSizeHigh)
            lifecycleScope.launch {
                storeSize(fontSizeHigh)
            }
        }
    }


}
