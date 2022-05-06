package tech.henriquedev.bankline.ui.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tech.henriquedev.bankline.R
import tech.henriquedev.bankline.databinding.ActivityBankStatementBinding
import tech.henriquedev.bankline.databinding.ActivityWelcomeBinding
import tech.henriquedev.bankline.domain.Correntista

class BankStatementActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ACCOUNT_HOLDER = "tech.henriquedev.bankline.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val accountHolder by lazy {
        intent.getParcelableExtra<Correntista>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}