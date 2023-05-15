package com.cnc.listviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cnc.listviewpractice.adapters.StudentAdapter
import com.cnc.listviewpractice.databinding.ActivityMainBinding
import com.cnc.listviewpractice.datas.Student

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    // 매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    val mStudentList = ArrayList<Student>()

    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mStudentList.add(Student("강호", 1985))
        mStudentList.add(Student("으네", 1993))
        mStudentList.add(Student("정솔", 1992))
        mStudentList.add(Student("영민", 1985))
        mStudentList.add(Student("용준", 1985))
        mStudentList.add(Student("진쥬", 1984))
        mStudentList.add(Student("규태", 1985))

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        binding.studentListView.adapter = mAdapter

        binding.studentListView.setOnItemClickListener { parent, view, position, id ->  
            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "${clickedStudent.name}이 클릭됨", Toast.LENGTH_SHORT).show()
            
        }
    }
}