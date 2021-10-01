# ViewToImage
East way to convert View into ImageView or Uri


Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			maven { url 'https://jitpack.io' }
		}
	}
  
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.akram6t:ViewToImage:Tag'
	}
  
  
  step 3 use this code in Activity
  
        ViewToImageView c2i = new ViewToImageView(MainActivity.this,layout,"name");
	
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageURI(c2i.getImageuri());
            }
        });
