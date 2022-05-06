package tech.henriquedev.bankline.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tech.henriquedev.bankline.R
import tech.henriquedev.bankline.databinding.ActivityWelcomeBinding
import tech.henriquedev.bankline.domain.Correntista
import tech.henriquedev.bankline.ui.statement.BankStatementActivity

class WelcomeActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btContinue.setOnClickListener {
            val accountHolderId = binding.etAccountHolderId.text.toString().toInt()
            val accountHolder = Correntista(accountHolderId)

            val intent = Intent(this, BankStatementActivity::class.java).apply {
                putExtra(BankStatementActivity.EXTRA_ACCOUNT_HOLDER, accountHolder)
            }

            startActivity(intent)
        }
    }
}