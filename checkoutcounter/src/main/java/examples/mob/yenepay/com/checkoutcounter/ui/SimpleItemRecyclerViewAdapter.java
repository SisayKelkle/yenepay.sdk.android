package examples.mob.yenepay.com.checkoutcounter.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import examples.mob.yenepay.com.checkoutcounter.ui.item.OnItemInteractionListner;
import examples.mob.yenepay.com.checkoutcounter.R;
import examples.mob.yenepay.com.checkoutcounter.StoreApp;
import examples.mob.yenepay.com.checkoutcounter.db.entity.StoreItem;
import examples.mob.yenepay.com.checkoutcounter.utils.Util;

public class SimpleItemRecyclerViewAdapter
        extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final OnItemInteractionListner mListner;
    private final List<StoreItem> mValues;
    private final boolean mTwoPane;
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StoreItem item = (StoreItem) view.getTag();
            mListner.onItemSelected(item, 1);
//            if (mTwoPane) {
//                Bundle arguments = new Bundle();
//                arguments.putString(ItemDetailFragment.ARG_ITEM_ID, item.id);
//                ItemDetailFragment fragment = new ItemDetailFragment();
//                fragment.setArguments(arguments);
//                mListner.getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.item_detail_container, fragment)
//                        .commit();
//            } else {
//                Context context = view.getContext();
//                Intent intent = new Intent(context, ItemDetailActivity.class);
//                intent.putExtra(ItemDetailFragment.ARG_ITEM_ID, item.id);
//
//                context.startActivity(intent);
//            }
        }
    };

    public SimpleItemRecyclerViewAdapter(OnItemInteractionListner parent,
                                         List<StoreItem> items,
                                         boolean twoPane) {
        mValues = items;
        mListner = parent;
        mTwoPane = twoPane;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).content);
        holder.mContentView.setText(String.format(StoreApp.getContext().getString(R.string.product_price2), mValues.get(position).price));
        holder.mImageView.setImageBitmap(Util.getProductImage(mValues.get(position).image));
        holder.mImageView.setOnClickListener(mOnClickListener);
        holder.mImageView.setTag(holder.mItem);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        StoreItem mItem;
        final ImageView mImageView;
        final TextView mIdView;
        final TextView mContentView;

        ViewHolder(View view) {
            super(view);
            mItem = null;
            mIdView = view.findViewById(R.id.id_text);
            mContentView = view.findViewById(R.id.content);
            mImageView = view.findViewById(R.id.img);
        }
    }
}