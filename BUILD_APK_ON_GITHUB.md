# Build Panda APK directly on GitHub

You can compile this Android project on GitHub without installing Android Studio locally.

## Run a build

1. Open the repository's **Actions** tab.
2. Select **Build Android APK**.
3. Click **Run workflow**, choose `main`, and start the workflow.
4. Wait for the workflow to finish.
5. Open the completed run and download the **panda-debug-apk** artifact.
6. Extract the ZIP to get the APK, transfer it to your Android phone, and install it. Android may ask you to allow installs from your browser or file manager.

A build also runs automatically when Android source or build files are pushed directly to `main`.

## Firebase configuration

The workflow uses a temporary placeholder `google-services.json` if the repository does not contain one. This allows the Google Services Gradle plugin to configure a CI build, but Firebase-backed functionality will not work correctly with placeholder values.

To build with your Firebase project without committing its configuration file:

1. Convert your Firebase `google-services.json` file to a single-line Base64 string locally.
2. In GitHub, open **Settings → Secrets and variables → Actions → New repository secret**.
3. Name the secret `GOOGLE_SERVICES_JSON_BASE64` and set its value to that Base64 string.
4. Run the workflow again.

Do not commit private API keys or signing keys. The artifact is a debug APK, not a Play Store release. Gemini/Picovoice or other service credentials may need separate configuration.

## Troubleshooting

Open the workflow run, select the failed job, and inspect the first Gradle error. A successful GitHub Actions build confirms compilation, not that every runtime service works on a real phone.
