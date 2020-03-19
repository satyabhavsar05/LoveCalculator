package com.example.lovecalculator


import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.fragment_result.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 */
lateinit var args: ResultFragmentArgs

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       args = ResultFragmentArgs.fromBundle(arguments!!)
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstname.text=args.nameFirst
        secondname.text=args.nameSecond
        val resultPercent = Random.nextInt(100)+1
        result.text= resultPercent.toString()

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.share_menu,menu)
    }
    private fun getShareIntent() : Intent {
        val args = ResultFragmentArgs.fromBundle(arguments!!)
        return ShareCompat.IntentBuilder.from(this.activity).setText(getString(R.string.share_success_text,args.nameSecond, args.nameFirst)).setType("text/plain").intent
    }
    private  fun shareSuccess() {
        startActivity(getShareIntent())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
        when(item!!.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

}
