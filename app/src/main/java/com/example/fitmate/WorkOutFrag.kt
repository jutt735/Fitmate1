package com.example.fitmate

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WorkOutFrag.newInstance] factory method to
 * create an instance of this fragment.
 */
class WorkOutFrag : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val lay= inflater.inflate(R.layout.fragment_work_out, container, false)

        val workouts: ArrayList<Excercises> = ArrayList()
        workouts.add(Excercises(R.drawable.chestworkout))
        workouts.add(Excercises(R.drawable.backworkout))
        workouts.add(Excercises(R.drawable.shoulderworkout))
        workouts.add(Excercises(R.drawable.bicepsworkout))
        workouts.add(Excercises(R.drawable.tricepsworkout))
        workouts.add(Excercises(R.drawable.absworkout))
        workouts.add(Excercises(R.drawable.legsworkout))

        val linearLayoutContainer: LinearLayout = lay.findViewById(R.id.linearLayoutContainer)

        for (exercise in workouts) {
            val itemView = LayoutInflater.from(context)
                .inflate(R.layout.excercises_list, linearLayoutContainer, false)
            val imageButton: ImageButton = itemView.findViewById(R.id.imageButton)
            imageButton.setImageResource(exercise.image)

        }

        val chest: ImageView =lay.findViewById(R.id.imageView70)
        val back: ImageView =lay.findViewById(R.id.imageView71)
        val shoulder: ImageView =lay.findViewById(R.id.imageView72)
        val bicep: ImageView =lay.findViewById(R.id.imageView73)
        val tricep: ImageView =lay.findViewById(R.id.imageView74)
        val abs: ImageView =lay.findViewById(R.id.imageView75)
        val leg: ImageView =lay.findViewById(R.id.imageView76)
        val cardiio:ImageView=lay.findViewById(R.id.imageView1000)

        chest.setOnClickListener{
            startActivity(Intent(activity,ChestWorkOut::class.java))
        }

        back.setOnClickListener{
            startActivity(Intent(activity,BackWorkOut::class.java))
        }
        shoulder.setOnClickListener{
            startActivity(Intent(activity,Shoulder_WorkOut::class.java))
        }
        bicep.setOnClickListener{
            startActivity(Intent(activity,Biceps_WorkOut::class.java))
        }
        tricep.setOnClickListener{
            startActivity(Intent(activity,Triceps_Workout::class.java))
        }
        abs.setOnClickListener{
            startActivity(Intent(activity,Abs_Workout::class.java))
        }
        leg.setOnClickListener{
            startActivity(Intent(activity,Legs_Workout::class.java))
        }

        cardiio.setOnClickListener{
            startActivity(Intent(activity,CArdio_workout::class.java))
        }

        return lay
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WorkOutFrag.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkOutFrag().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}