# Krews Boilerplate

Clone this project to get started quickly with [Krews](https://weng-lab.github.io/krews) using our best practices.

Then make changes in the following places:

- This Readme - Remove this section and put in your own project name and intro.
- `settings.gradle` - Add your own project name
- `build.gradle.kts` - Add your own "group" and version. Group can be anything and should describe you or 
your organization. It looks like *com.myorg.category* by convention.
- `src/main/kotlin` - Add your application logic here. Replace our examples.
- `configs` - Add your own configs here.

## Building

Just run `scripts/build.sh` to build. You should find your executable Jar in `build/$APP_NAME-$VERSION-exec.jar`

## Running

Once built, you can run `scripts/run.sh` with any Krews args. It's just a convenience 
wrapper for `java -jar build/*.jar`. 