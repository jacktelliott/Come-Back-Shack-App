package com.example.comebackshack;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;
import com.example.comebackshack.ui.requests.CouponRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/*
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CouponFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CouponFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CouponFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView couponListTextView;
    private TextView couponItem1TextView;
    private TextView couponItem2TextView;
    private TextView couponItem3TextView;
    private String coupon1;
    private String coupon2;
    private String coupon3;
    private String code1;
    private String code2;
    private String code3;
    private String title1;
    private String title2;
    private String title3;

    //private OnFragmentInteractionListener mListener;

    public CouponFragment() {
        // Required empty public constructor
    }

    /*
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CouponFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CouponFragment newInstance(String param1, String param2) {
        CouponFragment fragment = new CouponFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coupon, container, false);

        couponListTextView = view.findViewById(R.id.couponListTextView);
        couponItem1TextView = view.findViewById(R.id.couponItem1TextView);
        couponItem2TextView = view.findViewById(R.id.couponItem2TextView);
        couponItem3TextView = view.findViewById(R.id.couponItem3TextView);
        // Inflate the layout for this fragment

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.i("the response is", "["+response+"]");
                    JSONArray jsonArray = new JSONArray(response);
                    JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                    JSONObject jsonObject2 = jsonArray.getJSONObject(1);
                    JSONObject jsonObject3 = jsonArray.getJSONObject(2);
                    code1 = jsonObject1.getString("code1");
                    Log.d(code1, code1);
                    title1 = jsonObject1.getString("title1");
                    code2 = jsonObject2.getString("code2");
                    title2 = jsonObject2.getString("title2");
                    code3 = jsonObject3.getString("code3");
                    title3 = jsonObject3.getString("title3");

                    coupon1 = String.format("%s\nCoupon code: %s", title1, code1);
                    coupon2 = String.format("%s\nCoupon code: %s", title2, code2);
                    coupon3 = String.format("%s\nCoupon code: %s", title3, code3);

                    couponItem1TextView.setText(coupon1);
                    couponItem2TextView.setText(coupon2);
                    couponItem3TextView.setText(coupon3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(error.getMessage(), "Error: " + error.getMessage());
            }
        };
        coupon1 = String.format("%s\nCoupon code: %s", title1, code1);
        coupon2 = String.format("%s\nCoupon code: %s", title2, code2);
        coupon3 = String.format("%s\nCoupon code: %s", title3, code3);

        CouponRequest couponRequest = new CouponRequest(coupon1, coupon2, coupon3, responseListener, errorListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(couponRequest);
        return view;
    }

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
