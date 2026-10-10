# Build Panda APK directly on GitHub

You can compile this Android project on GitHub without installing Android Studio locally.

## Run a build

1. Open the repository's **Actions** tab.
2. Select **Build Android APK**.
3. Click **Run workflow**, choose the branch (usually `main`), and run it.
4. Wait for the workflow to finish successfully.
5. Open the completed workflow run and download the **panda-debug-apk** artifact.
6. Extract the artifact ZIP to get the APK, transfer it to your Android phone, and install it. You may need to allow your browser/file manager to install unknown apps.

Pull requests that change Android source or build files also trigger a build automatically. The workflow uploads a debug APK artifact for successful runs.

## Firebase configuration

The build uses a temporary placeholder `google-services.json` if the repository does not contain one. This is enough for the Google Services Gradle plugin to configure a CI build, but Firebase-backed functionality will not work correctly with placeholder values.

To build with your own Firebase project without committing its configuration file:

1. Convert your Firebase `google-services.json` file to a single-line Base64 string locally.
2. In GitHub, open **Settings → Secrets and variables → Actions → New repository secret**.
3. Name the secret `GOOGLE_SERVICES_JSON_BASE64` and set its value to that Base64 string.
4. Run the workflow again.

Do not commit private API keys or signing keys to the repository. The build is an unsigned-by-you debug APK signed with Android's standard debug key; it is suitable for personal testing, not a Play Store release. Gemini/Picovoice or other service credentials may need to be configured separately in the app's documented local configuration.

## If the build fails

Open the workflow run, select the failed job, and inspect the first Gradle error. A successful GitHub Actions build confirms compilation, not that every runtime service works on a real phone.
