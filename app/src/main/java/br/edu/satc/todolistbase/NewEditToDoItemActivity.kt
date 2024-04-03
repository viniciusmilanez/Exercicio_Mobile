package br.edu.satc.todolistbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.EventLogTags.Description
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.edu.satc.todolistbase.roomdatabase.ToDoItem

class NewEditToDoItemActivity : AppCompatActivity() {
    private lateinit var etTittle: EditText
    private lateinit var etDescription: EditText
    private lateinit var btsave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_edit_to_do_item)

        initDatabase()

        etTittle = findViewById(R.id.et_title)
        etDescription = findViewById(R.id.tv_description)
        btsave = findViewById(R.id.bt_save)

        bt_Save.SetOnClickListener{
            save()
        }
    }
    private fun save(){
        val toDoItem = ToDoItem(
            null,
            etTittle.text.toString(),
            etDescription.text.toString(),
            false
        )
        //salva
        db.toDoItemDao().insertAll(toDoItem)
        //mensagem
        Toast.makeText(this,"Tarefa salva com sucesso", Toast.LENGTH_SHORT.show())
        //fecha a tela
        finish()
    }
}