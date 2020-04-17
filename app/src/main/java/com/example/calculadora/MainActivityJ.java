package com.example.calculadora;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calculadora.databinding.ActivityMainBinding;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivityJ extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //Numbers
        binding.bt01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("1", true);
            }
        });
        binding.bt02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("2", true);
            }
        });
        binding.bt03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("3", true);
            }
        });
        binding.bt04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("4", true);
            }
        });
        binding.bt05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("5", true);
            }
        });
        binding.bt06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("6", true);
            }
        });
        binding.bt07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("7", true);
            }
        });
        binding.bt08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("8", true);
            }
        });
        binding.bt09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("9", true);
            }
        });
        binding.bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("0", true);
            }
        });
        binding.btPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression(".", true);
            }
        });

        //Operators
        binding.btMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("+", false);
            }
        });
        binding.btMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("-", false);
            }
        });
        binding.btMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("*", false);
            }
        });
        binding.btDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("/", false);
            }
        });
        binding.btSeparador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("()", false);
            }
        });
        binding.btPercentual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("%", false);
            }
        });
        binding.btIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendOnExpression("=", false);
            }
        });


        binding.btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btExpressao.setText("");
                binding.btResultado.setText("");
            }
        });
        binding.btIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Expression expression = new ExpressionBuilder(binding.btExpressao.getText().toString()).build();
                    Double result = expression.evaluate();
                    long longResult = result.longValue();
                    if (result == (double) longResult)
                        binding.btResultado.setText(Long.toString(longResult));
                    else
                        binding.btResultado.setText(Double.toString(result));
                } catch (Exception e) {
                    Log.d("Exception", " message : " + e.toString());
                }
            }
        });
        binding.btApagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = binding.btExpressao.getText().toString();
                if (!string.isEmpty()) {
                    binding.btExpressao.setText(string.substring(0, string.length() - 1));
                }
                binding.btResultado.setText("");
            }
        });
    }

    public void appendOnExpression(String string, Boolean canClear) {

        if (binding.btResultado.getText().length() != 0) {
            binding.btExpressao.setText("");
        }
        if (canClear) {
            binding.btResultado.setText("");
            binding.btExpressao.append(string);
        } else {
            binding.btExpressao.append(binding.btResultado.getText());
            binding.btExpressao.append(string);
            binding.btResultado.setText("");
        }
    }
}

