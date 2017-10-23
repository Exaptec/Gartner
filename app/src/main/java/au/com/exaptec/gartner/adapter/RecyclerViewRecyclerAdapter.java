package au.com.exaptec.gartner.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.aakira.expandablelayout.ExpandableLayout;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.ArrayList;

import au.com.exaptec.gartner.R;
import au.com.exaptec.gartner.ui.MainActivity;


public class RecyclerViewRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewRecyclerAdapter.ViewHolder> {
public static  final String TAG=RecyclerViewRecyclerAdapter.class.getSimpleName();
    private final ArrayList<String> data;
    private final ArrayList<String> dataAnswers;
    private MainActivity mActivity;
    private Context context;
    private SparseBooleanArray expandState = new SparseBooleanArray();

    public RecyclerViewRecyclerAdapter(final ArrayList<String> data, final ArrayList<String> dataAnswers, MainActivity mActivity) {
        this.data = data;
        this.dataAnswers = dataAnswers;
        this.mActivity = mActivity;
        for (int i = 0; i < data.size(); i++) {
            expandState.append(i, false);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        this.context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.recycler_view_list_row, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final String item = data.get(position);
        Log.d(TAG,item+ String.valueOf(data.size()));
        holder.setIsRecyclable(false);
        holder.textView.setText(item);
        holder.expandableLayout.setInRecyclerView(true);
        holder.expandableLayout.setInterpolator(new LinearInterpolator());
        holder.expandableLayout.setExpanded(expandState.get(position));
        holder.expandableLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                createRotateAnimator(holder.buttonLayout, 0f, 180f).start();
                expandState.put(position, true);
            }

            @Override
            public void onPreClose() {
                createRotateAnimator(holder.buttonLayout, 180f, 0f).start();
                expandState.put(position, false);
            }
        });

        holder.buttonLayout.setRotation(expandState.get(position) ? 180f : 0f);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                onClickButton(holder.expandableLayout, holder.answer,holder.getAdapterPosition());
            }
        });
    }

    private void onClickButton(final ExpandableLayout expandableLayout, final TextView answer_tv, final int position) {
        expandableLayout.toggle();
        String answer = dataAnswers.get(position);
        mActivity.speakQuestion(answer);
        answer_tv.setText(answer);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
        return animator;
    }

    public interface RobotSpeak {
        public void speakQuestion(String session);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public RelativeLayout buttonLayout;
        public TextView answer;
        /**
         * You must use the ExpandableLinearLayout in the recycler view.
         * The ExpandableRelativeLayout doesn't work.
         */
        public ExpandableLinearLayout expandableLayout;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.textView);
            buttonLayout = (RelativeLayout) v.findViewById(R.id.button);
            expandableLayout = (ExpandableLinearLayout) v.findViewById(R.id.expandableLayout);
            answer=(TextView) v.findViewById(R.id.textView_answer);
        }
    }
}