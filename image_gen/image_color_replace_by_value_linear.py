from PIL import Image
import colorsys
import sys


def image_color_replace_by_value(img, color_max, color_min, color_max_distance, color_min_distance):
    # Get all pixels in an array
    z = []
    for x in range(img.width):
        for y in range(img.height):
            pix = img.getpixel((x, y))
            if pix not in z:
                z.append(pix)

    # Remove all that have 0 alpha
    for zy in z:
        if not zy[3]:
            z.remove(zy)

    # Create a 2d list of colors and their rgb and hsv stuff
    colors_list = [[zy, colorsys.rgb_to_hsv(*zy[0:3])] for zy in z]

    # Get min value and value diff
    v_min = min(x[1][2] for x in colors_list)
    v_diff = max(x[1][2] for x in colors_list) - v_min

    # Get hsv colors for provided colors
    color_min_hsv = colorsys.rgb_to_hsv(*color_min)
    color_max_hsv = colorsys.rgb_to_hsv(*color_max)

    # Calculate slope values for hue, saturation, and value
    # y = mx+b
    h_m = (color_max_hsv[0] - color_min_hsv[0]) / (color_max_distance - color_min_distance)
    h_b = color_min_hsv[0] - (color_min_distance * h_m)
    s_m = (color_max_hsv[1] - color_min_hsv[1]) / (color_max_distance - color_min_distance)
    s_b = color_min_hsv[1] - (color_min_distance * s_m)
    v_m = (color_max_hsv[2] - color_min_hsv[2]) / (color_max_distance - color_min_distance)
    v_b = color_min_hsv[2] - (color_min_distance * v_m)

    # Go through each color and assign it a NEW color in hsv
    for c in colors_list:
        value_factor = (c[0][2] - v_min) / v_diff
        c_hsv = (
            min(max(h_b + h_m * value_factor, 0), 255),
            min(max(s_b + s_m * value_factor, 0), 255),
            min(max(v_b + v_m * value_factor, 0), 255)
        )
        c.append(colorsys.hsv_to_rgb(*c_hsv))
        c[2] = *(int(z + 0.5) for z in c[2]), c[0][3]

    # Go back through the image and replace each color with its new color
    for x in range(img.width):
        for y in range(img.height):
            pix = img.getpixel((x, y))
            if pix in z:
                for j in range(len(colors_list)):
                    if pix == colors_list[j][0]:
                        img.putpixel((x, y), colors_list[j][2])

    # Save image.
    img.save(sys.argv[1][:-4] + '_post.png')


if __name__ == '__main__':
    img = Image.open(sys.argv[1]).convert('RGBA')

    color_max = eval(sys.argv[2])
    color_min = eval(sys.argv[3])

    if len(sys.argv) == 4:
        image_color_replace_by_value(img, color_max, color_min)
    elif len(sys.argv) == 5:
        image_color_replace_by_value(img, color_max, color_min, float(sys.argv[4]))
    else:
        image_color_replace_by_value(img, color_max, color_min, float(sys.argv[4]), float(sys.argv[5]))
