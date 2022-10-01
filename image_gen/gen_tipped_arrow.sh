# Function to merge the generated images together.
merge_images() {
	composite -compose over -alpha On tipped_arrow/tail_post.png tipped_arrow/tip_post.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/$1_tipped_arrow.png
	composite -compose over -alpha On ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/$1_tipped_arrow.png tipped_arrow/rod.png ../src/main/resources/assets/teamindicatorsplus/textures/entity/projectiles/$1_tipped_arrow.png
}

# Set -e so if errors occur we're fine
set -e

# Set variables
HIGH_FACTOR_LIGHT=1
LOW_FACTOR_LIGHT=-5
HIGH_FACTOR_MID=1
LOW_FACTOR_MID=-6
HIGH_FACTOR_DARK=1
LOW_FACTOR_DARK=-5.5
TIP_TINT_STRENGTH=0.5

# black
echo -e "Generating BLACK tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(12,12,12)" "(5,5,5)" 1 0
python3 image_color_multiply.py tipped_arrow/tip.png "(12,12,12)" $TIP_TINT_STRENGTH
merge_images black

# dark blue
echo -e "Generating DARK BLUE tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(0,0,168)" "(0,0,41)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
python3 image_color_multiply.py tipped_arrow/tip.png "(0,0,168)" $TIP_TINT_STRENGTH
merge_images dark_blue

# dark green
echo -e "Generating DARK GREEN tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(0,168,0)" "(0,41,0)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
python3 image_color_multiply.py tipped_arrow/tip.png "(0,168,0)" $TIP_TINT_STRENGTH
merge_images dark_green

# dark aqua
echo -e "Generating DARK AQUA tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(0,168,168)" "(0,41,41)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
python3 image_color_multiply.py tipped_arrow/tip.png "(0,168,168)" $TIP_TINT_STRENGTH
merge_images dark_aqua

# dark red
echo -e "Generating DARK RED tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(168,0,0)" "(41,0,0)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
python3 image_color_multiply.py tipped_arrow/tip.png "(168,0,0)" $TIP_TINT_STRENGTH
merge_images dark_red

# dark purple
echo -e "Generating DARK PURPLE tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(168,0,168)" "(41,0,41)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
python3 image_color_multiply.py tipped_arrow/tip.png "(168,0,168)" $TIP_TINT_STRENGTH
merge_images dark_purple

# gold
echo -e "Generating GOLD tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(252,168,0)" "(62,41,0)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
python3 image_color_multiply.py tipped_arrow/tip.png "(252,168,0)" $TIP_TINT_STRENGTH
merge_images gold

# gray
echo -e "Generating GRAY tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(168,168,168)" "(41,41,41)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
python3 image_color_multiply.py tipped_arrow/tip.png "(168,168,168)" $TIP_TINT_STRENGTH
merge_images gray

# dark gray
echo -e "Generating DARK GRAY tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(84,84,84)" "(21,21,21)" $HIGH_FACTOR_DARK $LOW_FACTOR_DARK
python3 image_color_multiply.py tipped_arrow/tip.png "(84,84,84)" $TIP_TINT_STRENGTH
merge_images dark_gray

# blue
echo -e "Generating BLUE tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(84,84,252)" "(21,21,62)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
python3 image_color_multiply.py tipped_arrow/tip.png "(84,84,252)" $TIP_TINT_STRENGTH
merge_images blue

# green
echo -e "Generating GREEN tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(84,252,84)" "(21,62,21)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
python3 image_color_multiply.py tipped_arrow/tip.png "(84,252,84)" $TIP_TINT_STRENGTH
merge_images green

# aqua
echo -e "Generating AQUA tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(84,252,252)" "(21,62,62)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
python3 image_color_multiply.py tipped_arrow/tip.png "(84,252,252)" $TIP_TINT_STRENGTH
merge_images aqua

# red
echo -e "Generating RED tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(251,84,84)" "(62,21,21)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
python3 image_color_multiply.py tipped_arrow/tip.png "(251,84,84)" $TIP_TINT_STRENGTH
merge_images red

# light purple
echo -e "Generating LIGHT PURPLE tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(252,84,252)" "(62,21,62)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
python3 image_color_multiply.py tipped_arrow/tip.png "(252,84,252)" $TIP_TINT_STRENGTH
merge_images light_purple

# yellow
echo -e "Generating YELLOW tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(252,252,84)" "(62,62,21)" $HIGH_FACTOR_MID $LOW_FACTOR_MID
python3 image_color_multiply.py tipped_arrow/tip.png "(252,252,84)" $TIP_TINT_STRENGTH
merge_images yellow

# white
echo -e "Generating WHITE tipped arrow image..."
python3 image_color_replace_by_value_linear.py tipped_arrow/tail.png "(252,252,252)" "(62,62,62)" $HIGH_FACTOR_LIGHT $LOW_FACTOR_LIGHT
python3 image_color_multiply.py tipped_arrow/tip.png "(252,252,252)" $TIP_TINT_STRENGTH
merge_images white
