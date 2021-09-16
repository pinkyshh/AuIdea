package lipika.androidapp.gridlayoutadvisor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class specialRecyclerFragment : Fragment() {
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_advisor_speciality, container, false)

        val advisorSpeciality = ArrayList<specialty>()
        advisorSpeciality.add(specialty("COMPUTER VISION"))
        advisorSpeciality.add(specialty("OBJECT ORIENTED PROGRAMMING"))
        advisorSpeciality.add(specialty("CALCULUS"))
        advisorSpeciality.add(specialty("GPU/TPU"))
        advisorSpeciality.add(specialty("WEB APPLICATION DEVELOPMENT"))
        advisorSpeciality.add(specialty("RECOMMENDER SYSTEM"))
        advisorSpeciality.add(specialty("ARTIFICIAL INTELLIGENCE"))
        advisorSpeciality.add(specialty("COMPUTER PROGRAMMING"))
        advisorSpeciality.add(specialty("NETWORKING"))
        advisorSpeciality.add(specialty("DATABASE MANAGEMENT SYSTEM"))
        advisorSpeciality.add(specialty("MACHINE LEARNING"))
        advisorSpeciality.add(specialty("BLOCKCHAIN TECHNOLOGY"))
        advisorSpeciality.add(specialty("ALGORITHMS"))
        advisorSpeciality.add(specialty("STATISTICS"))
        advisorSpeciality.add(specialty("UX/UI DESIGN"))
        advisorSpeciality.add(specialty("NEURAL NETWORK"))
        advisorSpeciality.add(specialty("NATURAL LANGUAGE PROCESSINGS"))
        val rv = view.findViewById<RecyclerView>(R.id.rv_Special)
        val adapter = SpeacialityViewAdapter(requireContext(), advisorSpeciality)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

}