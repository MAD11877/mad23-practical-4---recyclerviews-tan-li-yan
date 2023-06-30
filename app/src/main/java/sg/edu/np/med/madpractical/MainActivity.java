package sg.edu.np.med.madpractical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        User myUser = new User();
        //Saving the user's name
        String name = myUser.name;
        //saving the user's description
        String description = myUser.description;
        TextView myHeader = findViewById(R.id.textView4);
        myHeader.setText(myUser.name + getIntent().getIntExtra("Number", 0));
        Button myButton = findViewById(R.id.button4);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //set the boolean to not equal the orignial state when the button is clicked.
                myUser.followed = !myUser.followed;
                if(myUser.followed == false)
                {
                    myButton.setText("Follow");
                    Toast.makeText(getApplicationContext(), "Unollowed", Toast.LENGTH_SHORT).show();
                }
                else{
                    myButton.setText("Unfollow");
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button message = findViewById(R.id.button5);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitySwitch = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(activitySwitch);
            }
        });
    }
}