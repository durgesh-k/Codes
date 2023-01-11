import java.util.*;

class Solution{
static void maxIndex(int n, int a)
{
int max_index = 0;
for (int i = 1; i <= n; i++)
{
	max_index += i;
}

int current_index = max_index,
					step = n;

while (true)
{
	while (current_index > 0 && n > 0)
	{
	current_index -= n;
	if (current_index == a)
	{
		current_index += n;
	}
	n--;
	}
	if (current_index <= 0)
	{
	System.out.println(max_index);
	break;
	}
	else
	{
	n = step;
	current_index = max_index - 1;
	max_index--;
	if (current_index == a)
	{
		current_index = max_index - 1;
		max_index--;
	}
	}
}
}

public static void main(String[] args)
{
maxIndex(4, 6);
maxIndex(2, 1);
maxIndex(3, 3);
maxIndex(2, 2);
}
}
