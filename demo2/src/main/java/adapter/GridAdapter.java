package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huixing.demo2.R;

/**
 * Created by huixing on 2016/10/25.
 */

public class GridAdapter extends BaseAdapter {

    private int images[] = {R.mipmap.add_pay_canyin_icon,R.mipmap.add_pay_yanjiu_icon,
    R.mipmap.add_pay_jiaotong_icon,R.mipmap.add_pay_gouwu_icon,R.mipmap.add_pay_yule_icon,
    R.mipmap.add_pay_touzikuisun_icon,R.mipmap.add_pay_shenghuafuwu_icon,
    R.mipmap.add_pay_chongzhi_icon,R.mipmap.add_pay_yiyao_icon,R.mipmap.add_pay_zhufang_icon,
    R.mipmap.add_pay_shuidianmei_icon,R.mipmap.add_pay_shicai_icon};
    private String title[] = {"餐饮","烟酒","交通","购物","娱乐",
            "投资亏损","生活服务","充值","医药","住房","水电煤","食材"};

    private Context context;

    public GridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView ==null){

            convertView = View.inflate(context,R.layout.grid_item,null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.iv_grid);
            holder.textView = (TextView) convertView.findViewById(R.id.tv_grid);

            convertView.setTag(holder);

        }else{

            holder = (ViewHolder) convertView.getTag();


        }

        holder.imageView.setImageResource(images[position]);
        holder.textView.setText(title[position]);

        return convertView;
    }

    class  ViewHolder{

        private ImageView imageView;
        private TextView textView;

    }




}
