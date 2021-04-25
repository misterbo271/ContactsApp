package com.mienpv.contacts.ui.adapter;

import android.animation.ValueAnimator;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.AppCompatImageButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mienpv.contacts.R;
import com.mienpv.contacts.helper.Utilities;
import com.mienpv.contacts.object.Contact;
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ViewHolder> {
    private ClickListener mClickListener;

    private ArrayList<Contact> mContactList;

    private final String mFragmentName;

    public ContactListAdapter(String fragmentName) {
        this.mFragmentName = fragmentName;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent,
                false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Contact contact = mContactList.get(position);
        holder.mContactName.setText(contact.getName());
        holder.mMobile.setText(contact.getPhone().getMobile());
        holder.mHome.setText(contact.getPhone().getHome());
        holder.mEmail.setText(contact.getEmail());
        holder.mAvatarImage.setImageResource(Utilities.setAvatar(contact.getGender()));
    }

    public void setContactList(ArrayList<Contact> contactList) {
        mContactList = contactList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mContactList == null ? 0 : mContactList.size();
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    /*Movie view holder class*/
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.contact_card_view)
        CardView mCardView;

        @BindView(R.id.avatar_image)
        ImageView mAvatarImage;

        @BindView(R.id.contact_name_textview)
        TextView mContactName;

        @BindView(R.id.contact_mobile_number_textview)
        TextView mMobile;

        @BindView(R.id.contact_home_number_textview)
        TextView mHome;

        @BindView(R.id.contact_email_textview)
        TextView mEmail;

        @BindView(R.id.call_button)
        AppCompatImageButton mCallButton;



        int minHeight;

        ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            assignMinHeight();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleCardViewHeight((int) (minHeight * 2.4));
                }
            });

        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                mClickListener.onItemClick(getAdapterPosition(), v);
            }
        }

        private void assignMinHeight() {
            mCardView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    mCardView.getViewTreeObserver().removeOnPreDrawListener(this);
                    minHeight = mCardView.getHeight();
                    ViewGroup.LayoutParams layoutParams = mCardView.getLayoutParams();
                    layoutParams.height = minHeight;
                    mCardView.setLayoutParams(layoutParams);
                    return true;
                }
            });
        }

        private void toggleCardViewHeight(int height) {
            if (mCardView.getHeight() == minHeight) {
                // expand
                expandView(height);
            } else {
                // collapse
                collapseView();
            }
        }

        void collapseView() {
            ValueAnimator anim = ValueAnimator.ofInt(mCardView.getMeasuredHeightAndState(),
                    minHeight);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = mCardView.getLayoutParams();
                    layoutParams.height = val;
                    mCardView.setLayoutParams(layoutParams);
                }
            });
            anim.start();
        }

        void expandView(int height) {
            ValueAnimator anim = ValueAnimator.ofInt(mCardView.getMeasuredHeightAndState(),
                    height);
            anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int val = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = mCardView.getLayoutParams();
                    layoutParams.height = val;
                    mCardView.setLayoutParams(layoutParams);
                }
            });
            anim.start();
        }
    }
}
