package com.example.beto.notas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.beto.notas.R;
import com.example.beto.notas.models.Board;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class BoardAdapter extends BaseAdapter {

    /** Creado por:
     // Alberto Ángel Cruz Alvarado
     // Aguilar Hernández María Teresa
     // Rojas Trujillo David**/

    private Context context;
    private List<Board> list;
    private int layout;


    public BoardAdapter(Context context, List<Board> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder vh;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.title = (TextView) convertView.findViewById(R.id.textViewBoardTitle);
            vh.notes = (TextView) convertView.findViewById(R.id.textViewBoardNotes);
            vh.createdAt = (TextView) convertView.findViewById(R.id.textViewBoardDate);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Board board = list.get(position);
        vh.title.setText(board.getTitle());

        int numberOfNotes = board.getNotes().size();
        String textForNotes = (numberOfNotes ==1) ? numberOfNotes + "Nota " : numberOfNotes + " Notas";
        vh.notes.setText(textForNotes);

        DateFormat df = new SimpleDateFormat("dd/MMMM/yyyy");
        String createdAt = df.format(board.getCreatedAt());
        vh.createdAt.setText(createdAt);

        return convertView;

    }

    public class ViewHolder {
        TextView title;
        TextView notes;
        TextView createdAt;
    }
}
