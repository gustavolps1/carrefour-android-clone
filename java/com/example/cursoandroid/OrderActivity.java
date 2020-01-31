package com.example.cursoandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class OrderActivity extends Activity {

    int quantity = 1;
    double orderTotal;
    double orderValue = 1.49;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        incrementQuantity();
        decreaseQuantity();
        handleOrder();

        TextView orderMessageTextView = findViewById(R.id.orderMessage);
        orderMessageTextView.setVisibility(View.INVISIBLE);


    }

    private void incrementQuantity() {

        Button incrementButton = findViewById(R.id.increment);

        incrementButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                TextView quantityTextView = findViewById(R.id.quantity);
                TextView orderTotalTextView = findViewById(R.id.orderTotal);



                if (quantity < 99) {
                    quantity = quantity + 1;

                    orderTotal = orderValue * quantity;


                    quantityTextView.setText(String.valueOf(quantity));
                    orderTotalTextView.setText(String.valueOf("R$" + orderTotal));
                }
            }
        });
    }

    private void decreaseQuantity() {

        Button decreaseButton = findViewById(R.id.decrease);

        decreaseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                TextView quantityTextView = findViewById(R.id.quantity);
                TextView orderTotalTextView = findViewById(R.id.orderTotal);



                if (quantity > 1) {

                    quantity = quantity - 1;

                    orderTotal = orderValue * quantity;


                    quantityTextView.setText(String.valueOf(quantity));
                    orderTotalTextView.setText(String.valueOf("R$" + orderTotal));
                }
            }

        });


    }

    private void handleOrder() {
        Button orderButton = findViewById(R.id.order);

        orderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TextView orderMessageTextView = findViewById(R.id.orderMessage);
                Button incrementButton = findViewById(R.id.increment);
                Button decreaseButton = findViewById(R.id.decrease);

                incrementButton.setEnabled(false);
                decreaseButton.setEnabled(false);
                orderMessageTextView.setVisibility(View.VISIBLE);
                startActivity(new Intent(OrderActivity.this, ListActivity.class));
            }
        });

    }

}
