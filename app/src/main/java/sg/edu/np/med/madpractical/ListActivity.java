package sg.edu.np.med.madpractical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity implements  RecyclerViewInterface {
    ArrayList<User> myList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for(int i = 0; i< 20; i++){
            User myUser = new User();
            Random random = new Random();
            String name = myUser.name;
            name = "Name-" + random.nextInt();
            String description = myUser.description;
            description = "Description:" + random.nextInt();
            Boolean isFollowed = myUser.followed;
            isFollowed = random.nextBoolean();
            myUser.setName(name);
            myUser.setDescription(description);
            myUser.setFollowed(isFollowed);
            myList.add(myUser);
        }
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ListAdapter listAdapter = new ListAdapter(myList, this);
        LinearLayoutManager mlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(listAdapter);

        /*robot.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        int numGenerated = numberGenerator();
                        Bundle extras = new Bundle();
                        extras.putInt("Number", numGenerated);
                        Intent activityName = new Intent(ListActivity.this, MainActivity.class);
                        activityName.putExtras(extras);
                        startActivity(activityName);
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.dismiss();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();



            }
        });*/
    }

    @Override
    public void onItemClick(int position) {
        User clickedUser = myList.get(position);
        AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
            builder.setTitle("Profile");
            builder.setMessage(clickedUser.getName());
            builder.setCancelable(false);
            builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){
                    Bundle extras = new Bundle();
                    extras.putString("name", clickedUser.getName());
                    extras.putString("description", clickedUser.getDescription());
                    extras.putBoolean("isFollowed", clickedUser.isFollowed());
                    Intent activityName = new Intent(ListActivity.this, MainActivity.class);
                    activityName.putExtras(extras);
                    startActivity(activityName);
                }
            });
            builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){
                    dialog.dismiss();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();

    }

}