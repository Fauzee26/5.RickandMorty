package fauzi.hilmy.rm_characted.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResultsItem implements Parcelable {

	@SerializedName("image")
	private String image;

	@SerializedName("gender")
	private String gender;

	@SerializedName("species")
	private String species;

	@SerializedName("created")
	private String created;

	@SerializedName("origin")
	private Origin origin;

	@SerializedName("name")
	private String name;

	@SerializedName("location")
	private Location location;

	@SerializedName("episode")
	private List<String> episode;

	@SerializedName("id")
	private int id;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	@SerializedName("status")
	private String status;

	protected ResultsItem(Parcel in) {
		image = in.readString();
		gender = in.readString();
		species = in.readString();
		created = in.readString();
		name = in.readString();
		episode = in.createStringArrayList();
		id = in.readInt();
		type = in.readString();
		url = in.readString();
		status = in.readString();
	}

	public static final Creator<ResultsItem> CREATOR = new Creator<ResultsItem>() {
		@Override
		public ResultsItem createFromParcel(Parcel in) {
			return new ResultsItem(in);
		}

		@Override
		public ResultsItem[] newArray(int size) {
			return new ResultsItem[size];
		}
	};

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setSpecies(String species){
		this.species = species;
	}

	public String getSpecies(){
		return species;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setOrigin(Origin origin){
		this.origin = origin;
	}

	public Origin getOrigin(){
		return origin;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLocation(Location location){
		this.location = location;
	}

	public Location getLocation(){
		return location;
	}

	public void setEpisode(List<String> episode){
		this.episode = episode;
	}

	public List<String> getEpisode(){
		return episode;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeString(image);
		parcel.writeString(gender);
		parcel.writeString(species);
		parcel.writeString(created);
		parcel.writeString(name);
		parcel.writeStringList(episode);
		parcel.writeInt(id);
		parcel.writeString(type);
		parcel.writeString(url);
		parcel.writeString(status);
	}
}