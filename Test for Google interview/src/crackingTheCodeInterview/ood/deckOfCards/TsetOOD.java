package crackingTheCodeInterview.ood.deckOfCards;

public class TsetOOD {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		System.out.println(s.getArr()[0]);

		Song song = new Song("oren");
		Album album = new Album(song, "Aname");
		System.out.println(song.getAlbum().name);
	}
	
	static class Album{
		String name;
		
		public Album(Song song, String name){
			this.name = name;
			song.setAlbum(this);
			
		}
		
	}
	
	static class Song{
		private String name;
		private Album album;
		
		public Song(String name){
			this.name = name;
		}
		
		public void setAlbum(Album album){
			this.album = album;
		}
		public Album getAlbum(){
			return album;
		}
	}
	
	static class Singleton{
		
		private static Singleton instance;
		private int[] arr;
		
		private Singleton(){
			arr = new int[]{33};
		}
		
		public static Singleton getInstance(){
			if(instance == null){
				instance = new Singleton();
			}
			return instance;
		}
		
		public int[] getArr(){
			return arr;
		}
		
	}

}
