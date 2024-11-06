package com.example.recyclerview_grid

import Image
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerview_grid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val adapterDisaster = ImageAdapter(generateDataDummy()){
                image ->
            Toast.makeText(this@MainActivity, "Source image: ${image.imgSource}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvImages.apply {
                adapter = adapterDisaster
                layoutManager = GridLayoutManager(this@MainActivity, 3)
            }
        }
    }

    fun generateDataDummy(): List<Image> {
        return listOf(
            Image(imgSource = "https://img.freepik.com/free-photo/autumn-leaf-falling-revealing-intricate-leaf-vein-generated-by-ai_188544-9869.jpg"),
            Image(imgSource = "https://img.freepik.com/free-photo/vibrant-autumn-maple-leaves-nature-beauty-showcased-generated-by-ai_188544-15039.jpg"),
            Image(imgSource = "https://img.freepik.com/premium-photo/abstract-background-with-tropical-leaves-magenta-azure-generative-ai_836899-677.jpg?semt=ais_hybrid"),
            Image(imgSource = "https://img.freepik.com/premium-photo/photo-branches-leaves-desktop-wallpaper-backgrounds_763111-16240.jpg"),
            Image(imgSource = "https://img.freepik.com/premium-photo/leaf-with-colors-autumn-it_856987-51.jpg"),
            Image(imgSource = "https://img.freepik.com/premium-photo/autumn-falling-leaves-background-illustration-generative-ai_115919-13306.jpg"),
            Image(imgSource = "https://img.freepik.com/premium-photo/photo-close-up-leaves-background_763111-31984.jpg"),
            Image(imgSource = "https://img.freepik.com/premium-photo/orange-leaf-sitting-blue-background_889227-3089.jpg"),
            Image(imgSource = "https://img.freepik.com/premium-photo/autumn-composition-frame-leaves-two-branches-with-red-leaves-plum-light-blue-background-flat-lay-top-view-copy-space_100894-564.jpg")
        )
    }
}