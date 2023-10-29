### Touroll

Java application to create video from multiple sources made by students at Touro University.

#### Dependencies

[FFmpeg](https://ffmpeg.org/) - Generate video from images and audio\
[ffmpeg4j](https://github.com/Manevolent/ffmpeg4j) - Java wrapper around FFmpeg\
[commonmark-java](https://github.com/commonmark/commonmark-java) - Parse and Render Markdown\
[Java TTS](https://www.geeksforgeeks.org/converting-text-speech-java/) - Convert Text to Speech\
[FreeTTS](https://freetts.sourceforge.io/)

[Markdown Tutorial](https://www.markdowntutorial.com/)\
[Markdown Cheat Sheet](https://www.markdownguide.org/cheat-sheet/)\
[Draw.io](https://app.diagrams.net/)

### Students

[Chana Chambre](https://github.com/chanacham) \
[Meira Cohen](https://www.github.com/mc-student) \
[Emmy Runge](https://github.com/emmyrunge) \
[Libby Kenigsberg](https://github.com/lkenigsb) \
[Elka Halberstam](https://github.com/elkyhalberstam) \
[Elky Schlesinger](https://github.com/ElkySchles)

### Video Creation

Instructions to build command line prompt to covert imagines to video and then run it

[Download ffmpeg onto your device] (https://ffmpeg.org/)

1. Navigate to the Download button on the left
2. Go to the Get Packages and Executable Filed
3. Select your OS (MacOS/Windows)

**MacOS**
Download the
ffmpeg-6.0.7z and follow prompts

**Windows**
Select Windows builds by BtbN
Select the bottom most zip file (ffmpeg-master-latest-win64-gpl.zip) and follow prompts

**Note**

- To make sure ffmpeg works
    - Go to the directory ffmpeg is saved in
    - type ffmpeg -version in the command line / terminal and press enter.

[Converting images to a video] (https://www.youtube.com/watch?v=thDma0lO0U8)

- Height of images need to be divisible by 2
- Command line prompt with parems:
    - -r frames per second
    - -i input images
    - -pix_fmt format of the pictures
    - last parem is the name of the video created.videoType (typically mp4)
        - ffmpeg -r 1/5 -i img%01d.jpg -pix_fmt yuv420p testFfmpegVideo.mp4

[Adding audio to an image] (https://trac.ffmpeg.org/wiki/Slideshow)

- ffmpeg -loop 1 -i img.jpg -i audio.wav -c:v libx264 -c:a aac -b:a 192k -shortest out.mp4
    - this is to one image

[Concating two video files] (https://superuser.com/questions/607383/concat-two-mp4-files-with-ffmpeg-without-losing-quality)

- Concat two mp4 files with ffmpeg without losing quality - Super User
- Create a text file and include the paths and names of each file to concatenate (or "join"). Example file,
  input.txt:
    - file '/home/jenia/input1.mp4'
    - file '/home/jenia/input2.mp4'
    - file '/home/jenia/input3.mp4'

- Now you can use the concat demuxer:
    - ffmpeg -f concat -i input.txt -codec copy output.mp4

[Running a command in Java] (https://stackoverflow.com/questions/16452964/how-do-i-execute-windows-commands-in-java/16453015#16453015)