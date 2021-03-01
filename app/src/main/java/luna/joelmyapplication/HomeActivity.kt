package luna.joelmyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class   HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var intent = Intent(this, Products::class.java)

        button_colddrinks.setOnClickListener{
            intent.putExtra("type", "coldDrinks")
            startActivity(intent)
        }

        button_hotdrinks.setOnClickListener{
            intent.putExtra("type", "hotDrinks")
            startActivity(intent)
        }
        button_salties.setOnClickListener{
            intent.putExtra("type", "salties")
            startActivity(intent)
        }

        button_sweets.setOnClickListener{
            intent.putExtra("type", "sweets")
            startActivity(intent)
        }
    }
}
