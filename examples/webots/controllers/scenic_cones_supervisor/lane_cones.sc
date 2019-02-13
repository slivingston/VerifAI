
from scenic.simulators.webots.road.world import setLocalWorld
setLocalWorld(__file__, '../../worlds/shattuck_build.wbt')

from scenic.simulators.webots.road.road_model import *

# Pick location for blockage
curb = Uniform(*workspace.slowCurbs)
blockageSite = OrientedPoint on curb

# Place cones
spot1 = OrientedPoint left of blockageSite by (0.3, 1)
cone1 = TrafficCone at spot1, facing (0, 360) deg

spot2 = OrientedPoint ahead of spot1 by (-1.5, -0.75) @ (1, 4)
cone2 = TrafficCone at spot2, facing (0, 360) deg

cone3 = TrafficCone ahead of spot2 by (-1.5, -0.75) @ (1, 4), \
	facing (0, 360) deg, \
	with color [0, 0, 1]

# Place disabled car ahead of cones
SmallCar ahead of spot2 by (-1, 0.5) @ (4, 10), facing (0, 360) deg

# Place ego car some way back from the site
spot = blockageSite offset along roadDirection by (-3.5, -0.5) @ (-20, -30)
ego = ToyotaPrius at spot, with roadDeviation (-10, 10) deg

# Place another car
# SmallCar on visible road, with roadDeviation (-10, 10) deg
