package sg.edu.np.med.madpractical;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private ArrayList<User> user_list;
    //on click interface
    private final RecyclerViewInterface recyclerViewInterface;

    public ListAdapter(ArrayList<User> user, RecyclerViewInterface recyclerViewInterface){
        this.user_list= user;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_item, parent,false);
        ListViewHolder holder = new ListViewHolder(view, recyclerViewInterface);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        User user_items = user_list.get(position);
        holder.name.setText(user_items.getName());
        holder.description.setText(user_items.getDescription());
    }

    @Override
    public int getItemCount() {
        return user_list.size();
    }




}
