from pytube import YouTube
import os

while True:
    link = input("Enter the link of the YouTube video you want to download : ")
    yt = YouTube(link)

    print("Title: ", yt.title)
    print("Number of views: ", yt.views)
    print("Length of video: ", yt.length)
    print("Rating of video: ", yt.rating)

    download = input("Do you wish to download this video? Y/N : ")

    if download not in ("Y", "y"):
        continue

    download_type = input("Would you like a video or an audio download? V/A : ")

    if download_type in ("A", "a"):
        ys = yt.streams.filter(only_audio=True).first()
    else:
        ys = yt.streams.get_highest_resolution()

    print("Downloading...")
    out_file = ys.download(
        'C:/Users/Administrator/PycharmProjects/Python code/Projects/Mini Projects/Youtube downloader/Videos'
    )
    print("Download completed!!!")

    if download_type in ("A", "a"):
        base, ext = os.path.splitext(out_file)
        new_file = base + '.mp3'
        os.rename(out_file, new_file)
        print("Audio Download completed!!!")

    download_again = input("Do you wish to download another video? Y/N : ")

    if download_again in ("N", "n"):
        break
