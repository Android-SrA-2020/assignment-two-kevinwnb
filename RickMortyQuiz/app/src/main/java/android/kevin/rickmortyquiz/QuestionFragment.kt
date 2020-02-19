package android.kevin.rickmortyquiz


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_question.view.*

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment() {
    lateinit var buttonPressed: String
    private var questionToDisplay: Int = 0

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    data class Question(val q: Int, val boolean: Boolean)

    private fun GetButtonPressed(view: View) {
        when (view.id) {
            R.id.true_button -> buttonPressed = "True"
            R.id.false_button -> buttonPressed = "False"
        }
        solveCurrentQuestion()
    }

    fun solveCurrentQuestion() {
        if (questionBank[questionToDisplay].boolean == buttonPressed.toBoolean()) {
            Toast.makeText(this.context, "Congratulations you are correct", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this.context, "Sorry but your answer was not correct", Toast.LENGTH_SHORT).show()
        }
    }

    private fun forward() {
        val questionText: TextView = findViewById(R.id.question_text)
        if (questionToDisplay == 19) {
            questionToDisplay = 0
        } else {
            questionToDisplay++
        }
        questionText.text =
            "Question " + (questionToDisplay + 1) + ": " + getString(questionBank[questionToDisplay].q)
    }

    private fun back() {
        val questionText: TextView = findViewById(R.id.question_text)
        if (questionToDisplay == 0) {
            questionToDisplay = 19
        } else {
            questionToDisplay--
        }
        questionText.text =
            "Question " + (questionToDisplay + 1) + ": " + getString(questionBank[questionToDisplay].q)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentQuestionBinding>(
            inflater,
            R.layout.fragment_about, container, false
        )

        binding.question_text.text =
            "Question " + (questionToDisplay + 1) + ": " + getString(R.string.question_1)

        val trueButton: Button = binding.true_button
        trueButton.setOnClickListener { GetButtonPressed(it) }

        val falseButton: Button = binding.false_button
        falseButton.setOnClickListener { GetButtonPressed(it) }


        val forwardButton: Button = binding.forward_button
        forwardButton.setOnClickListener { forward() }

        val backButton: Button = binding.back_button
        backButton.setOnClickListener { back() }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu, menu)
    }
}
