# Ghost Blog Android App

This is an Android application developed in Java that allows users to access and read posts from a Ghost blog using the Ghost API. The app provides a seamless and user-friendly interface for browsing and consuming content from the blog.

## Features
- **Post Listing**: The app retrieves and displays a list of posts from the Ghost blog, including the post title, author, and publication date.
- **Post Details**: Users can view the full content of a selected post, including text, images, and formatting.

## Comming Soon Features
- **Authentication**: Users can authenticate themselves with their Ghost blog credentials or API key to access protected content.
- **Search**: The app enables users to search for specific posts based on keywords or tags.
- **Favorites**: Users can mark posts as favorites to save them for later reference.
- **Offline Access**: The app supports offline access, allowing users to read previously accessed posts even without an internet connection.
- **Notifications**: Users can opt-in to receive push notifications for new blog posts or updates.


## Dependencies

- [Ghost API](https://ghost.org/docs/api/v3/)
- [volly](https://square.github.io/volly/)
- [Glide](https://github.com/bumptech/glide)
- [Room Persistence Library](https://developer.android.com/training/data-storage/room)

## Installation

To run this app locally, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/ghost-blog-android-app.git`
2. Open the project in Android Studio.
3. Configure the necessary dependencies in the `build.gradle` files.
4. Build and run the app on an Android emulator or device.

## Configuration

Before running the app, make sure to configure the following:

- **Ghost API Key**: Obtain an API key from your Ghost blog. Replace the placeholder in the code with your actual API key.
- **API Endpoint**: Set the API endpoint URL in the app to match your Ghost blog's API endpoint.

## Usage

Once the app is installed and configured, users can launch it on their Android devices. They will be presented with a list of blog posts retrieved from the Ghost blog. Users can tap on a post to view its details or perform a search to find specific posts. The app also allows users to mark posts as favorites for easy access later.

## Contributing

Contributions to this project are welcome! If you encounter any issues or have suggestions for improvements, please open an issue or submit a pull request on the GitHub repository.

## License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use, modify, and distribute the code as per the license terms.

## Acknowledgements

- This app utilizes the Ghost API to fetch blog content. Special thanks to the Ghost team for providing a powerful and flexible API.
- The project's dependencies, including OkHttp, Glide, and Room Persistence Library, have greatly contributed to the app's functionality and performance.
