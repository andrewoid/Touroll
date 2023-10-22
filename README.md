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

[Download ffmpeg onto your device] (https://amiaopensource.github.io/ffmpeg-artschool/#install-or-update-ffmpeg)

Mac/Linux

1. Open terminal, check if have ffmpeg installed \
   Type ffmpeg -version and press enter
    - If the output says command not found, you will have to install ffmpeg. Continue to step 3.
    - If the first line of output starts with ffmpeg version 3 or lower, you will have to update your installation of
      ffmpeg. Continue to step 3.
    - If the first line of output starts with ffmpeg version 4, you have the version of ffmpeg required for the
      workshop.
      Go to Testing Your Setup.
2. We will use homebrew to install or upgrade ffmpeg. To check you have homebre installed, type brew -version and press
   enter.
    - If the output says command not found, you will have to install homebrew. Copy the following command, paste it into
      your terminal, and run it. While this command runs, you may have to enter your password or respond y several times
      in
      order to grant permission for the installation to complete. Then, continue to step 3
        - /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install.sh)"
    - Otherwise, continue to step 3.
3. In terminal, type brew update && brew upgrade ffmpeg and press enter.
    - If the output says brew not installed, type brew install ffmpeg and press enter.

Windows

1. Open a Pwershell window, check if you have ffmpeg installed and what version you have installed.
   Type ffmpeg.exe -version and press enter.
    - If the output says command not found, you will have to install ffmpeg. Continue to step 3.
    - If the first line of output starts with ffmpeg version 3 or lower, you will have to update your installation of
      ffmpeg. Continue to step 3
    - If the first line of output starts with ffmpeg version 4, you have the version of ffmpeg required for the
      workshop.
      Go to Testing Your Setup.
2. We will use scoop to install or upgrade ffmpeg and install ported versions of common bash programms (coreutils). To
   check you have scoop installed type scoop and press enter.
    - If the output says command not found, you will have to install scoop. Copy the following command, paste it into
      your
      Powershell window, and run it. Then, continue to step 3
        - iwr -useb get.scoop.sh | iex
    - If you get an error, you will need to grant permissions to run the installation script. Copy the following
      command,
      paste it into your Powershell window, and run it.
        - Set-ExecutionPolicy RemoteSigned -scope CurrentUser
    - Otherwise, continue to step 3.
3. In the Powershell window, type scoop install ffmpeg coreutils and press enter.
    - If ffmpeg is already installed, type scoop update ffmpeg and press enter.

Testing Your Setup

Mac/Linux

1. In the terminal, type ffmpeg -version and press enter.

Windows

2. Type ffmpeg.exe -version and press enter.

[The command to convert images to a video] (https://www.youtube.com/watch?v=thDma0lO0U8)

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