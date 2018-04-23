using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Geometric;
using Microsoft.QualityTools.Testing.Fakes;

namespace GeometricTest
{
    [TestClass]
    public class GeometricFigureAnalyzerTest
    {
        [TestMethod]
        public void CompareCircuitsEqualsTest()
        {
            IGeometricFigure figure1 = new Geometric.Fakes.StubIGeometricFigure()
            { 
               CountCircuit = () => { return 45.5; }
            };

            IGeometricFigure figure2 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountCircuit = () => { return 45.5; }
            };
            GeometricFiguresAnalyzer analyzer = new GeometricFiguresAnalyzer(figure1, figure2);
            Assert.AreEqual(0, analyzer.compareCiruits());
        }

        [TestMethod]
        public void CompareCircuitsFirstGreaterTest()
        {
            IGeometricFigure figure1 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountCircuit = () => { return 50.5; }
            };

            IGeometricFigure figure2 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountCircuit = () => { return 45.5; }
            };
            GeometricFiguresAnalyzer analyzer = new GeometricFiguresAnalyzer(figure1, figure2);
            Assert.AreEqual(1, analyzer.compareCiruits());
        }

        [TestMethod]
        public void CompareCircuitsFirstLowerTest()
        {
            IGeometricFigure figure1 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountCircuit = () => { return 40.5; }
            };

            IGeometricFigure figure2 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountCircuit = () => { return 45.5; }
            };
            GeometricFiguresAnalyzer analyzer = new GeometricFiguresAnalyzer(figure1, figure2);
            Assert.AreEqual(-1, analyzer.compareCiruits());
        }

        [TestMethod]
        public void CompareSurfacesEqualsTest()
        {
            IGeometricFigure figure1 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountSurface = () => { return 45.5; }
            };

            IGeometricFigure figure2 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountSurface = () => { return 45.5; }
            };
            GeometricFiguresAnalyzer analyzer = new GeometricFiguresAnalyzer(figure1, figure2);
            Assert.AreEqual(0, analyzer.compareSurfaces());
        }

        [TestMethod]
        public void CompareSurfacesFirstGreaterTest()
        {
            IGeometricFigure figure1 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountSurface = () => { return 50.5; }
            };

            IGeometricFigure figure2 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountSurface = () => { return 45.5; }
            };
            GeometricFiguresAnalyzer analyzer = new GeometricFiguresAnalyzer(figure1, figure2);
            Assert.AreEqual(1, analyzer.compareSurfaces());
        }

        [TestMethod]
        public void CompareSurfacetsFirstLowerTest()
        {
            IGeometricFigure figure1 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountSurface = () => { return 40.5; }
            };

            IGeometricFigure figure2 = new Geometric.Fakes.StubIGeometricFigure()
            {
                CountSurface = () => { return 45.5; }
            };
            GeometricFiguresAnalyzer analyzer = new GeometricFiguresAnalyzer(figure1, figure2);
            Assert.AreEqual(-1, analyzer.compareSurfaces());
        }
    }
}
