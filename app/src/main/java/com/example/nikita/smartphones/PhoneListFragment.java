package com.example.nikita.smartphones;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class PhoneListFragment extends Fragment {
    private PhoneAdapter phoneAdapter;
    private RecyclerView recyclerView;

    private class PhoneAdapter extends Adapter<PhoneHolder> {
        private List<Phone> phones;

        public PhoneAdapter(List<Phone> phones) {
            this.phones = phones;
        }

        public PhoneHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new PhoneHolder(LayoutInflater.from(PhoneListFragment.this.getActivity()).inflate(R.layout.item_list, parent, false));
        }

        public void onBindViewHolder(PhoneHolder holder, int position) {
            holder.bindPhone((Phone) this.phones.get(position));
        }

        public int getItemCount() {
            return this.phones.size();
        }
    }

    private class PhoneHolder extends ViewHolder implements OnClickListener {
        private TextView headName;
        private ImageView imagePreview;
        private Phone phone;

        public PhoneHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.headName = (TextView) itemView.findViewById(R.id.text_preview);
            this.imagePreview = (ImageView) itemView.findViewById(R.id.image_preview);
        }

        public void bindPhone(Phone phone) {
            this.phone = phone;
            this.imagePreview.setImageResource(phone.getDrawablePhoto());
            this.headName.setText(phone.getPhoneName());
        }

        public void onClick(View v) {
            PhoneListFragment.this.startActivity(PhoneActivity.newIntent(PhoneListFragment.this.getActivity(), this.phone.getId()));
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.phone_fragment_list, container, false);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    private void updateUI() {
        this.phoneAdapter = new PhoneAdapter(PhoneLab.get(getActivity()).getPhones());
        this.recyclerView.setAdapter(this.phoneAdapter);
    }
}
