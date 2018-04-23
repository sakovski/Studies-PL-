using System;
using Geometric;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace GeometricTest
{
    [TestClass]
    public class RectangleTest
    {
        public TestContext TestContext { get; set; }
        private double delta = 0.1;

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides less than zero")]
        public void RectangleALessThanZeroTest()
        {
            Rectangle rectangle = new Rectangle(-4, 4);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides less than zero")]
        public void RectangleBLessThanZeroTest()
        {
            Rectangle rectangle = new Rectangle(4, -4);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides less than zero")]
        public void RectangleABLessThanZeroTest()
        {
            Rectangle rectangle = new Rectangle(-4, -4.2);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentOutOfRangeException), "Sides less than zero")]
        public void RectangleABZeroTest()
        {
            Rectangle rectangle = new Rectangle(0, 0);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void RectangleCircuitTest()
        {
            Rectangle rectangle = new Rectangle(Double.Parse(TestContext.DataRow["RectangleA"].ToString()), Double.Parse(TestContext.DataRow["RectangleB"].ToString()));
            double expected = Double.Parse(TestContext.DataRow["RectangleCircuit"].ToString());
            Assert.AreEqual(expected, rectangle.countCircuit(), delta);
        }

        [TestMethod]
        [DataSource("Microsoft.VisualStudio.TestTools.DataSource.CSV", "|DataDirectory|\\data.csv", "data#csv", DataAccessMethod.Sequential), DeploymentItem("data.csv")]
        public void RectangleSurfaceTest()
        {
            Rectangle rectangle = new Rectangle(Double.Parse(TestContext.DataRow["RectangleA"].ToString()), Double.Parse(TestContext.DataRow["RectangleB"].ToString()));
            double expected = Double.Parse(TestContext.DataRow["RectangleSurface"].ToString());
            Assert.AreEqual(expected, rectangle.countSurface(), delta);
        }

        public void RectangleToStringTest()
        {
            Rectangle rectangle = new Rectangle(4.5, 5.5);
            StringAssert.Equals("Rectangle with a = 4.5; b = 5.5", rectangle.ToString());
        }
    }
}
