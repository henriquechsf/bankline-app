package tech.henriquedev.bankline.ui.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import tech.henriquedev.bankline.R
import tech.henriquedev.bankline.databinding.ActivityBankStatementBinding
import tech.henriquedev.bankline.databinding.ActivityWelcomeBinding
import tech.henriquedev.bankline.domain.Correntista
import tech.henriquedev.bankline.domain.Movimentacao
import tech.henriquedev.bankline.domain.TipoMovimentacao

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

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()
    }

    private fun findBankStatement() {
        val dataSet = arrayListOf<Movimentacao>()
        dataSet.add(Movimentacao(1, "03/05/2022 09:25:00", "Lorem Ipsum", 1500.0, TipoMovimentacao.RECEITA, 1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:25:00", "Netflix", 50.0, TipoMovimentacao.DESPESA, 1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:25:00", "Roupas", 500.0, TipoMovimentacao.DESPESA, 1))
        dataSet.add(Movimentacao(1, "03/05/2022 09:25:00", "Bonus", 200.0, TipoMovimentacao.RECEITA, 1))

        binding.rvBankStatement.adapter = BankStatementAdapter(dataSet)
    }
}