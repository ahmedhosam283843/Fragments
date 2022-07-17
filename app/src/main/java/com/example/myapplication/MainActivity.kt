package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ItemTodoBinding
import retrofit2.HttpException
import retrofit2.http.HTTP
import java.io.IOException

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecyclerView()
        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true
            val response = try {
                RetrofitInstance.api.getTodos()
            }
            catch (e: IOException){
                Log.e("MainActivity", "Network error")
                return@launchWhenCreated
            }
            catch (e: HttpException){
                Log.e("MainActivity", "Http error")
                return@launchWhenCreated
            }
            if (response.isSuccessful && response.body() != null){
                todoAdapter.todos =  response.body()!!
            }
            else{
                Log.e("MainActivity", "Error: ${response.code()}")
            }
            binding.progressBar.isVisible = false
        }
    }
    private fun setUpRecyclerView() = binding.rvTodos.apply{
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }


}