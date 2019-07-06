package com.example.dhani.kholas.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dhani.kholas.R;
import com.example.dhani.kholas.TampilQuranActivity;
import com.example.dhani.kholas.fragmen.BaseSurat;
import com.example.dhani.kholas.fragmen.Surat;

import java.util.List;


public class SuratAdapter extends BaseAdapter {
    Surat context;
    List<BaseSurat> listSurah;

    private View vi;
    private ViewHolder viewHolder;
    private LayoutInflater layoutInflater = null;

    public SuratAdapter(Surat context, List<BaseSurat> listSurah) {
        this.context = context;
        this.listSurah = listSurah;
        layoutInflater = (LayoutInflater) context.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listSurah.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        vi = view;
        //Populate the Listview
        final int pos = position;
        BaseSurat baseSurah = listSurah.get(pos);
        if(vi == null) {
            vi = layoutInflater.inflate(R.layout.list_surat, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.name = vi.findViewById(R.id.nama_surat);
            viewHolder.no = vi.findViewById(R.id.no);
            viewHolder.jml = vi.findViewById(R.id.jml_ayat);
            vi.setTag(viewHolder);
        }else
            viewHolder = (ViewHolder) view.getTag();

        viewHolder.name.setText(baseSurah.getNama());
        viewHolder.no.setText(baseSurah.getNomor());
        viewHolder.jml.setText(baseSurah.getAyat().toString()+" ayat");


        viewHolder.layout_surah = vi.findViewById(R.id.layout_list_surah);
        viewHolder.layout_surah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(vi.getContext(), TampilQuranActivity.class);
                intent.putExtra("posisi", pos);
                vi.getContext().startActivity(intent);
//                Toast.makeText(vi.getContext(),"tes"+pos,Toast.LENGTH_SHORT).show();
            }
        });

        return vi;
    }

    public class ViewHolder{
        TextView name;
        TextView no;
        TextView jml;
        LinearLayout layout_surah;
    }


}
