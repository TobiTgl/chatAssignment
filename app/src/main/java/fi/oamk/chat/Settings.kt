package fi.oamk.chat

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class  Settings : AppCompatActivity(){

    @SuppressLint("RestrictedAPI")

    private lateinit var email: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        email = findViewById(R.id.email)

        supportActionBar?.apply {
            title="Settings"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val currentUser = intent.getParcelableExtra<FirebaseUser>("currentUser")
        email.text = currentUser?.email
        email.text = currentUser?.email
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun singOut (view: View){
        FirebaseAuth.getInstance().signOut()
        email.text = ""
    }
}