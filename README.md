#  Computer-Graphics-Ray-Tracing

CS485


This is a project that was given to me while in a computer graphics class at SIUC.
The goal of this project was to complete sections of the code base, which were outlined in the assignment PDF, which ultimately would allow us to render 3D models using different types of cameras, surfaces, and shaders using ray tracing technology.
The assigned sections are labeled in the code with single line comments and appear in multiple classes of the code.
The required content was based off of materials and formulas we studied in class.
The biggest skill I took away from this project was the ability to have an entire code base given to me and learn how it actually works.
In order to write the code for this project it was imperative to understand how the classes and methods worked within.

SECTIONS WHERE ADJUSTMENTS WERE NECESSARY:

OrthographicCamera.java
PerspectiveCamera.java
Sphere.java 
Triangle.java
Scene.java
RayTracer.java
PhongBRDF.java
LambertianBRDF.java
ReflectionShader.java
Shader.java

TO TEST THE CODE:

The data directory contains scene files and reference images for the purpose of testing your code. Right click on the RayTracer file in Package Explorer, and choose Run As → Java Application. These scene files are organized into several subdirectories:

• fast_scenes: a collection of simple scenes that should render very quickly, under a second
each, so that you can quickly tell what is working. You should re-render these constantly as
you work, so that you learn right away if you have broken something that used to work.

• mesh_scenes: scenes that test the ability to handle larger triangle meshes. Since your ray
tracer takes time linear in the number of triangles, these will be slower to render. When you are iterating on one of these results, don’t hesitate to edit the input file to make the output image temporarily much smaller!

• textured_scenes: scenes that test the texture mapping features.
Without just a directory name passed as a command line argument, the ray tracer will attempt to render all scenes in the corresponding scene directory (i.e. data/scenes/ray1/dirname). If you want to render specific scenes, you can list the file names individually on the command line.

You can set up command line arguments from the Run dialog (Run Configurations) in Eclipse. Choose the Arguments tab, and provide your command line arguments in Program arguments. Alternatively, you can run the program from the command line, which is sometimes more

convenient for rapid iteration. You will need to set both the class path and the library path; a command line like the following, executed in the Ray/ project directory, will do it:

java -cp bin/:deps/lib/openexrjni-3.0.0.jar -Djava.library.path=deps/native/macosx/ray1.RayTracer fast_scenes/
 
with an appropriate substitution to the library path for Windows or Linux. Note that RayTracer prepends data/scenes/ray1 to its arguments. This means that you only need to provide a scene file name to render it. For example, if you give the argument fast_scenes/one-sphere.xml to the RayTracer it will load the scene file data/scenes/ray1/fast_scenes/one-sphere.xml and produce an output image in the same directory as the scene file.

If you would like to change the default scene location, there is a -p command line option that allows you to specify a different default path instead of using data/scenes/ray1.
