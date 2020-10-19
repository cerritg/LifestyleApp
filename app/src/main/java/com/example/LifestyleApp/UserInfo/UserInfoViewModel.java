//package com.example.LifestyleApp.UserInfo;
//
//import android.app.Application;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.lifecycle.AndroidViewModel;
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.MutableLiveData;
//import androidx.lifecycle.Observer;
//
//import com.example.LifestyleApp.R;
//import com.google.gson.Gson;
//
//import org.json.JSONException;
//
//import java.util.Date;
//import java.util.List;
//
//public class UserInfoViewModel extends AndroidViewModel {
//    private MutableLiveData<UserData> userData = new MutableLiveData<UserData>();
//    private UserInfoRepository mUserInfoRepository;
//
//    public UserInfoViewModel(Application application) {
//        super(application);
//        mUserInfoRepository = new UserInfoRepository(application);
//    }
//
//    public void loadUserDataFromRepo() {
//        mUserInfoRepository.getUserData().observeForever(userInfoObserver);
//        mUserInfoRepository.loadUserDataFromDB();
//        mUserInfoRepository.getUserData().removeObserver(userInfoObserver);
//    }
//
//    final Observer<UserData> userInfoObserver = new Observer<UserData>() {
//        @Override
//        public void onChanged(@Nullable final UserData newUserData) {
//            if (userData != null) {
//                userData.setValue(newUserData);
//            }
//        }
//    };
//
//    public MutableLiveData<UserData> getUserData() {
//        return userData;
//    }
//
//    public void insertUserInfo1Data(String email,
//                                    TextView heightTextView,
//                                    TextView weightTextView,
//                                    TextView genderTextView,
//                                    TextView dobTextView) throws JSONException {
//        if (heightTextView != null && weightTextView != null && genderTextView != null && dobTextView != null) {
//            String height = heightTextView.getText().toString();
//            String weight = weightTextView.getText().toString();
//            String gender = genderTextView.getText().toString();
//            String dob = dobTextView.getText().toString();
//
//            if (!height.equals("Height") && !weight.equals("Weight") && !gender.equals("Gender") && !dob.equals("Birthday")) {
//
//                int ft = Integer.parseInt(height.split(" ")[0]);
//                int in = Integer.parseInt(height.split(" ")[2]);
//                int heightInInches = (ft * 12) + in;
//
//                float fWeight = Float.parseFloat(weight.split(" ")[0]);
//
//                double bmi = ((703 * fWeight) / Math.pow(heightInInches, 2));
//
//                Long dobDate = TypeConverters.dateToTimestamp(new Date(dob));
//
//                UserInfoInput input = new UserInfoInput();
//                input.setHeight(heightInInches);
//                input.setWeight(fWeight);
//                input.setBmi(bmi);
//                input.setGender(gender);
//                input.setDOB(dobDate);
//                Gson gson = new Gson();
//
//                String userInputJson = gson.toJson(input);
//
//                mUserInfoRepository.insert("userInfo1_table", userInputJson);
//            }
//        }
//    }
//
//
//    private static class UserInfoInput {
//        private String city;
//        private String country;
//        private int height;
//        private float weight;
//        private double bmi;
//        private String gender;
//        private Long dob;
//        private String profilePicture;
//
//        public UserInfoInput() {
//            city = "";
//            country = "";
//            height = 0;
//            weight = 0;
//            bmi = 0;
//            gender = "";
//            dob = Long.valueOf(0);
//            profilePicture = "";
//        }
//
//        private void setHeight(int height) {
//            this.height = height;
//        }
//
//        private void setWeight(float weight) {
//            this.weight = weight;
//        }
//
//        private void setBmi(double bmi) {
//            this.bmi = bmi;
//        }
//
//        private void setGender(String gender) {
//            this.gender = gender;
//        }
//
//        private void setDOB(Long dob) {
//            this.dob = dob;
//        }
//
//        private void setProfilePicture(String profilePicture) {
//            this.profilePicture = profilePicture;
//        }
//
//        private int getHeight() {
//            return this.height;
//        }
//
//        private float getWeight() {
//            return this.weight;
//        }
//
//        private double getBMI() {
//            return this.bmi;
//        }
//
//        private String getGender() {
//            return this.gender;
//        }
//
//        private Long getDOB() {
//            return this.dob;
//        }
//
//    }
//}
