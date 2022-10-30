import matplotlib.pyplot as plt
import pandas as pd
import csv
sorts=["new_quick","bubble","merge","insertion","heap","selection"]
fig, axes = plt.subplots()
for sort in sorts:
    df = pd.read_csv(f'{sort}.csv')
    axes.scatter(df["array sizes"], df["durations"],label=f'{sort}',sizes=[2])
plt.legend()
plt.show()
