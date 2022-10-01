from PIL import Image
import sys


def image_color_multiply(img, color_mult, factor=1):
    # Split image into seperate channels
    r, g, b, a = img.split()

    # Multiply the things by each color factor
    r = r.point(lambda i: i * (255 - ((255 - color_mult[0]) * factor)) / 255)
    g = g.point(lambda i: i * (255 - ((255 - color_mult[1]) * factor)) / 255)
    b = b.point(lambda i: i * (255 - ((255 - color_mult[2]) * factor)) / 255)

    # Merge the image back together
    out = Image.merge('RGBA', (r, g, b, a))

    # Save image.
    out.save(sys.argv[1][:-4] + '_post.png')
    

if __name__ == '__main__':
    img = Image.open(sys.argv[1]).convert('RGBA')

    color_mult = eval(sys.argv[2])

    if len(sys.argv) > 3:
        image_color_multiply(img, color_mult, float(sys.argv[3]))
    else:
        image_color_multiply(img, color_mult)