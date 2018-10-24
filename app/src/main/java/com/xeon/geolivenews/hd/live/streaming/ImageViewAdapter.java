package com.xeon.geolivenews.hd.live.streaming;

/**
 * Created by tayyab on 12/17/17.
 */

public class ImageViewAdapter {

//    public Context context;
//    public List<NewsInfo> imageInfos;
//
//    public ImageViewAdapter(Context context, List<NewsInfo> imageInfos) {
//        this.context = context;
//        this.imageInfos = imageInfos;
//    }
//
//    @Override
//    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View itemview = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.card, parent, false);
//        return new ImageViewHolder(itemview);
//    }
//
//
//    @Override
//    public void onBindViewHolder(final ImageViewHolder holder, int position) {
//
////        Toast.makeText(context,position,Toast.LENGTH_SHORT).show();
//        //  ImageInfo imageInfo = imageInfos.get(position);
//
//
//        holder.imagename.setText(imageInfos.get(position).name.toString().trim());
//        holder.im.setBackground(imageInfos.get(position).d);
//
//    }
//
//
//    @Override
//    public int getItemCount() {
//
//        return imageInfos.size();
//    }
//
//    public void AddNewItems(List<NewsInfo> imageInfoList) {
//        //imageInfos = imageInfoList;
//        //  notifyDataSetChanged();
//
//
//    }
//
//    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//
//
//        public TextView imagename;
//        public  ImageView im;
//
//        public ImageViewHolder(View itemView) {
//            super(itemView);
//            imagename = itemView.findViewById(R.id.name);
//            im = itemView.findViewById(R.id.icon);
//
//
//            itemView.setOnClickListener(this);
//        }
//
//        /**
//         * Called when a view has been clicked.
//         *
//         * @param v The view that was clicked.
//         */
//        @Override
//        public void onClick(View v) {
//
//
//
//            Intent i = new Intent(itemView.getContext(), MainActivity.class);
//            i.putExtra("news",imagename.getText().toString().trim());
//            itemView.getContext().startActivity(i);
//
//
//        }
//
//
//    }
}
