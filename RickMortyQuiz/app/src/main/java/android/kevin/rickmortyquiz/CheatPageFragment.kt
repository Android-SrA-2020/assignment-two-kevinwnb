package android.kevin.rickmortyquiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_cheatpage.view.*
import kotlinx.android.synthetic.main.fragment_question.view.*

/**
 * A simple [Fragment] subclass.
 */
class CheatPageFragment : Fragment() {

    fun CheatButtonClick(answer: Boolean) {
        val answerText = findViewById(R.id.answer_text)
        answerText.text = answer.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentCheatPageBinding>(
            inflater,
            R.layout.fragment_cheatpage, container, false
        )

        val args: QuestionFragmentArgs by navArgs()
        val question = args.question
        val answer = args.answer

        val cheatButton = binding.cheat_button
        cheatButton.setOnClickListener { CheatButtonClick(answer) }

        binding.question_text = question.toString()

        return binding.root
    }
}